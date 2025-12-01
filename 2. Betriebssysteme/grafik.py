import matplotlib.pyplot as plt

# Daten aus den beiden ./mem Aufrufen
data = {
    3000: [2274.86, 6081.31, 8451.90, 8781.49, 9114.83, 8658.86, 9191.85, 9247.82, 9122.98, 9119.27, 9167.98],
    7000: [2873.20, 625.97, 494.71, 646.43, 823.20, 595.80, 832.12, 677.25, 607.14, 814.94, 655.39]
}

# X-Werte: Arbeitsspeichergröße in MB (für jeden Durchlauf identisch)
x_3000 = [3000] * len(data[3000])
x_7000 = [7000] * len(data[7000])

# Y-Werte: Bandbreite
y_3000 = data[3000]
y_7000 = data[7000]

# Plot erstellen
plt.figure(figsize=(10, 6))
plt.scatter(x_3000, y_3000, label='3000 MB', marker='o')
plt.scatter(x_7000, y_7000, label='7000 MB', marker='x')
plt.title("Bandbreite in Abhängigkeit vom allokierten Speicher")
plt.xlabel("Speichergröße (MB)")
plt.ylabel("Bandbreite (MB/s)")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig("/mnt/data/memory_bandwidth_plot.png")
plt.show()
