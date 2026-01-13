package heapsort;

import java.util.Arrays;
import insertionSearch.*;
import mergeSort.*;
import quickSort.*;
import selectionSearch.SelectionSearch;

class Main {
    public static void main(String[] args) {

        Node[] a = new Node[17];   // HeapSort → Node[]
        int[] b  = new int[17];
        int[] c  = new int[17];
        int[] d  = new int[17];
        int[] e = new int[17];
        int[] arr = {6,5,4,3,2,1};

        Node[] f = new Node[arr.length];

        for(int i = 0; i < arr.length ; i++){
            f[i] = new Node(arr[i]);
        }


        // Zufallszahlen
        for (int i = 0; i < a.length; i++) {
            int rnd = (int)(Math.random() * 168);

            a[i] = new Node(rnd);
            b[i] = rnd;
            c[i] = rnd;
            d[i] = rnd;
            e[i] = rnd;
        }

        System.out.println("//----------------------------------------------------------//");

        Heapsort.heap_sort(a);
        SelectionSearch.selectionSearch(b);
        QuickSort.quicksort(c, 0, c.length - 1);
        MergeSort.mergeSort(d);
        InsertionSearch.insertionSearch(e);

        System.out.println("Heapsort       : " + Arrays.toString(toIntArray(a)));
        System.out.println("Selection Sort : " + Arrays.toString(b));
        System.out.println("QuickSort      : " + Arrays.toString(c));
        System.out.println("MergeSort      : " + Arrays.toString(d));
        System.out.println("Insertion-Sort : " + Arrays.toString(e));
         System.out.println("Heapsort       : " + Arrays.toString(toIntArray(f)));

        System.out.println("//----------------------------------------------------------//");

        System.out.println("Vergleiche Heapsort        : " + Heapsort.comparisons);
        System.out.println("Vergleiche Selection Sort  : " + SelectionSearch.vergleiche);
        System.out.println("Vergleiche Quicksort       : " + QuickSort.vergleiche);
        System.out.println("Vergleiche MergeSort       : " + MergeSort.vergleiche);
        System.out.println("Vergleiche Insertion-Sort  : " + InsertionSearch.vergleiche);
    }

    // Hilfsmethode nur für die Ausgabe
    private static int[] toIntArray(Node[] a) {
        int[] out = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = a[i].key;
        }
        return out;
    }
}
