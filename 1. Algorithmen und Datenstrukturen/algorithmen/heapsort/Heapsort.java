package heapsort;

public class Heapsort {

    /** zählt nur Schlüsselvergleiche
     * parent(i) = (i - 1) / 2
     * left(i) = 2*i + 1
     * right(i) = 2*i + 2
     */

    public static int comparisons = 0;

    public void reset(){
        comparisons = 0;
    }

    public static void heapify(Node[] a, int heapSize, int pos) {
        int largest = pos;

        int left  = 2 * pos;
        int right = left + 1;

        // Linkes Kind prüfen
        if (left < heapSize) {
            comparisons++;
            if (a[left].key > a[largest].key) {
                largest = left;
            }
        }

        // Rechtes Kind prüfen
        comparisons++;
        if (right < heapSize) {
            comparisons++;
            if (a[right].key > a[largest].key) {
                largest = right;
            }
        }

        // Falls Heap-Eigenschaft verletzt
        comparisons++;
        if (largest != pos) {
            Node temp = a[pos];
            a[pos] = a[largest];
            a[largest] = temp;

            heapify(a, heapSize, largest);
        }
    }

    public static void buildHeap(Node[] a) {
        int n = a.length;

        // letzter innerer Knoten
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
    }

    public static void heap_sort(Node[] a) {
        comparisons = 0;
        buildHeap(a);

        for (int end = a.length - 1; end > 0; end--) {

            // Maximum ans Ende tauschen
            Node temp = a[0];
            a[0] = a[end];
            a[end] = temp;

            // Heap-Eigenschaft wiederherstellen
            heapify(a, end, 0);
        }
    }



    public static int getComparisons() {
        return comparisons;
    }
}