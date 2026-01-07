package heapsort;

import java.util.Arrays;
import insertionSearch.*;
import mergeSort.*;
import quickSort.*;
import selectionSearch.SelectionSearch;

class Main {
    public static void main(String[] args) {
        int[] a = new int[17];
        int[] b = new int[17];
        int[] c = new int[17];
        int[] d = new int[17];

        // Zufallszahlen
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 168);
            b[i] = (int)(Math.random() * 168);
            c[i] = (int)(Math.random() * 168);
            d[i] = (int)(Math.random() * 168);

        }

        int[] testArr; // nur für die abgabe falls man ein bestimmtes nehm soll
        System.out.println("//----------------------------------------------------------//");
        Heapsort.sort(a);
        SelectionSearch.selectionSearch(b);
        QuickSort.quicksort(c, 0, c.length-1);
        MergeSort.mergeSort(d);
        System.out.println("Heapsort       : "+Arrays.toString(a));
        System.out.println("Selection Sort : "+Arrays.toString(b));
        System.out.println("QuickSort      : "+Arrays.toString(c));
        System.out.println("MergeSort      : "+Arrays.toString(d));
        System.out.println("//----------------------------------------------------------//");
        System.out.println("Vergleiche Heapsort       : " + Heapsort.getComparisons());
        System.out.println("Vergleiche Selection Sort : " + SelectionSearch.vergleiche);
        System.out.println("Vergleiche Quicksort      : " + QuickSort.vergleiche);
        System.out.println("Vergleiche mergeSort      : " + MergeSort.vergleiche);

    }
}
