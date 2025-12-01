import matplotlib.pyplot as plt

import re
from collections import OrderedDict

PAGE_BITS = 12   # 4 KB pages

def parse_trace(filename):
    addrs = []
    regex = re.compile(r'[ILS]\s+([0-9a-fA-F]+),')
    with open(filename) as f:
        for line in f:
            m = regex.search(line)
            if m:
                addr = int(m.group(1), 16)
                page = addr >> PAGE_BITS
                addrs.append(page)
    if not addrs:
        print("Warnung: Keine Adressen gefunden.")
    return addrs



def simulate_lru(pages, cache_size):
    cache = OrderedDict()
    hits = 0

    for p in pages:
        if p in cache:
            hits += 1
            cache.move_to_end(p)
        else:
            if len(cache) >= cache_size:
                cache.popitem(last=False)
            cache[p] = True

    return hits / len(pages)


def working_set_curve(trace_file, sizes):
    pages = parse_trace(trace_file)
    results = []
    for s in sizes:
        hit_rate = simulate_lru(pages, s)
        results.append((s, hit_rate))
    return results


if __name__ == "__main__":
    # Beispiel: Cachegrößen von 1 bis 16384
    sizes = [2**i for i in range(1, 15)]
    results = working_set_curve("C:\\Users\\justi\\OneDrive\\Desktop\Semester 3\\2. Betriebssysteme\\trace.txt", sizes)

    for s, hr in results:
        print(f"Cache={s:5d}  Hit-Rate={hr:.4f}")


sizes = [s for s, _ in results]
hits  = [h for _, h in results]

plt.plot(sizes, hits)
plt.xscale("log")
plt.xlabel("Cachegröße (Seiten)")
plt.ylabel("Hit-Rate")
plt.title("Working-Set-Kurve für ls")
plt.grid(True)
plt.show()
