package binarySearch;

import java.util.Arrays;

public class Dynamic_Array {

    public int[] a;       // aktuelles Array
    public int anzElem;   // Anzahl der belegten Elemente
    public int zuweisungen = 0;

    public Dynamic_Array() {
        a = new int[1];
        anzElem = 0;
    }

    // Vergrößern (Faktor 2)
    private void enlarge() {
        int size = a.length;
        if (size == 0) size = 1;

        int[] newA = new int[size * 2];

        for (int i = 0; i < anzElem; i++) {
            newA[i] = a[i];
            zuweisungen++;
        }

        a = newA;
        zuweisungen++;
    }

    // Verkleinern (Faktor 1/2)
    private void shrink() {
        if (a.length <= 1) return;

        int newSize = a.length / 2;
        if (anzElem > newSize) return; // Sicherheitscheck

        int[] newA = new int[newSize];

        for (int i = 0; i < anzElem; i++) {
            newA[i] = a[i];
            zuweisungen++;
        }

        a = newA;
        zuweisungen++;
    }

    // sortiertes Einfügen
    public boolean insert(int key) {

        // zuerst testen ob key existiert
        if (search(key) >= 0) return false; // Key existiert

        if (anzElem == a.length)
            enlarge();

        int links = 0;
        int rechts = anzElem - 1;

        // Position suchen, an die eingefügt werden muss
        while (links <= rechts) {
            int mid = (links + rechts) / 2;
            if (a[mid] < key) {
                links = mid + 1;
            } else {
                rechts = mid - 1;
            }
        }

        // Elemente nach rechts schieben
        for (int i = anzElem - 1; i >= links; i--) {
            a[i + 1] = a[i];
            zuweisungen++;
        }

        a[links] = key;
        anzElem++;
        zuweisungen++;

        return true;
    }

    // binäre Suche
    public int search(int key) {
        int links = 0;
        int rechts = anzElem - 1;

        while (links <= rechts) {
            int mid = (links + rechts) / 2;

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                rechts = mid - 1;
            } else {
                links = mid + 1;
            }
        }

        return -1; // nicht vorhanden
    }

    // Interpolant schätzt anhand vom gegeben Key an welcher Position es muss
    public int searchInterpolant(int key) {
        int links = 0;
        int rechts = anzElem - 1;

        while (links <= rechts && key >= a[links] && key <= a[rechts]) {

            if (a[rechts] == a[links]) {   // Division durch 0 vermeiden
                if (a[links] == key) return links;
                else return -1;
            }

            int pos = links + (key - a[links]) * (rechts - links)
                            / (a[rechts] - a[links]);

            if (a[pos] == key)
                return pos;

            if (a[pos] < key)
                links = pos + 1;
            else
                rechts = pos - 1;
        }

        return -1;
    }

    // Entfernen
    public boolean remove(int key) {
        int pos = search(key);
        if (pos < 0) return false;

        // Elemente nach links schieben
        for (int i = pos; i < anzElem - 1; i++) {
            a[i] = a[i + 1];
            zuweisungen++;
        }

        anzElem--;

        if (anzElem == a.length / 2)
            shrink();

        return true;
    }

    public void ausgabe() {
        // Gibt die einträge des Arrays aus. Die Leerstellen werden dabei abgeschnitten
        System.out.println(Arrays.toString(Arrays.copyOf(a, anzElem)));
    }
}
