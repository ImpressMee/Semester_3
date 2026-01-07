package heapsort;

public class Heapsort {
    /** zählt nur Schlüsselvergleiche
     * parent(i) = (i - 1) / 2
     * left(i) = 2*i + 1
     * right(i) = 2*i + 2
    **/
    private static int comparisons = 0;

    public static void heapify(int[] a, int heapSize, int pos){
        int largest = pos;

        int left = 2 * pos + 1;
        int right = 2 * pos + 2;

        // Prüfe das Linke Kind
        if(left < heapSize) {
            comparisons++;
            if(a[left] > a[largest]) {
                largest = left;
            }
        }

        // Prüfe das Rechts Kind
        if(right < heapSize) {
            comparisons++;
            if(a[right] > a[largest]) {
                largest = right;
            }
        }

        // Falls Heap verletzt, tauschen und rekursiv reparieren
        if(largest != pos) {
            int temp = a[pos];
            a[pos] = a[largest];
            a[largest] = temp;

            heapify(a, heapSize, largest);
        }
    }

    public static void buildHeap(int[] arr) {
        int n = arr.length;

        // letzter innere Knoten
        // n/2 -1 weil alle Indizes welche größer als n/2 sind, sind automatisch heaps
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(arr,n,i);
        }
    }

    public static void sort(int[] arr) {
        comparisons = 0;
        buildHeap(arr);

                for (int end = arr.length - 1; end > 0; end--) {

            // Tausche Maximum (Wurzel) ans Ende
            int temp = arr[0];
            arr[0] = arr[end];
            arr[end] = temp;

            // Heap-Eigenschaft wiederherstellen
            heapify(arr, end, 0);
        }
    }

        public static long getComparisons() {
        return comparisons;
    }


}
