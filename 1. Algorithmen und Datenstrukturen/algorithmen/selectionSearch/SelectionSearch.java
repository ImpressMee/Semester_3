package selectionSearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Selection Search O(n²):
 * Ein in-place-Sortierverfahren ohne zusätzliches Array.
 * Für jede Position i wird im restlichen Array das kleinste Element gesucht.
 * Nach dem vollständigen Durchlauf wird dieses Minimum genau einmal
 * mit dem Element an Position i getauscht.
 *
 * Beispiel:
 * Ausgang: 9 1 8 3
 *
 * Für i = 0 wird zunächst 9 als Ausgangswert für das Minimum angenommen.
 * Beim Weitergehen wird 1 gefunden und bleibt für den restlichen Durchlauf das Minimum.
 * Am Ende des Durchlaufs werden 9 und 1 getauscht.
 *
 * Ergebnis: 1 9 8 3
 */


public class SelectionSearch {
    static int zuweisungen = 0;
    public static int vergleiche = 0;

    public static void selectionSearch(int[] unsortedArray){
        vergleiche = 0;
        zuweisungen = 0;
        int n = unsortedArray.length;
        int temp = 0;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for (int j = i+1; j < n; j++) {
                vergleiche++;
                if(unsortedArray[j] < unsortedArray[min]){
                    min = j;
                }
            }
            if (min != i) {
                temp = unsortedArray[i];
                zuweisungen++;
                unsortedArray[i] = unsortedArray[min];
                zuweisungen++;
                unsortedArray[min] = temp;
                zuweisungen++; 
            }
        }
    }

    public static void main(String[] args) {
        int[] meinArray = {1,4,6,8,7,3,10,9,5,18,2,60,2,4,85,2,1,35,4,8,5,4,8,7,9,5,4,54,6,2,12,35};
        System.out.println(Arrays.toString(meinArray));

        selectionSearch(meinArray);

        System.out.println(Arrays.toString(meinArray));
        System.out.println("Zuweisungen = "+ SelectionSearch.zuweisungen);

        int[] randArr = new int[1000];
        
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            randArr[i] = i; //r.nextInt(1000) + 1; // 1–1000
        }

        selectionSearch(randArr);

        System.out.println("-----------------------------------\n"+
                            Arrays.toString(randArr)+"\n"+
                            "----------------------------------\n");
        System.out.println("Zuweisungen = "+ SelectionSearch.zuweisungen);
        System.out.println("Vergleiche = "+ SelectionSearch.vergleiche);

    }
}
