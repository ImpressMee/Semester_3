package insertionSearch;

import java.util.Arrays;
import java.util.Random;

/**
 * Insertion Sort O(n²):
 * Sortiert das Array, indem jedes Element an seine richtige Stelle in den bereits
 * sortierten linken Teil eingefügt wird.
 * Für Position i wird das aktuelle Element (temp) nach links geschoben, bis alle
 * größeren Elemente verdrängt sind. Anschließend wird temp an der passenden
 * Position eingesetzt.
 *
 * Beispiel:
 * Ausgang: 5 2 1 6
 *
 * Für i = 1: temp = 2 -> 5 wird nach rechts verschoben -> 2 wird vorne eingesetzt.
 * Ergebnis nach Schritt: 2 5 1 6
 *
 * 2 5 1 6
 * i = 2: temp = 1
 * 5 wird nach rechts verschoben → 2 wird nach rechts verschoben
 * 1 wird an Index 0 eingesetzt.
 *
 * Ergebnis: 1 2 5 6
 */

public class InsertionSearch {

    static int zuweisungen = 0;
    static int vergleiche = 0;

    private static void insertionSearch(int[] nums) {
        vergleiche = 0;
        zuweisungen = 0;
        // Starte am Index 1
        for (int i = 1; i < nums.length; i++) {
            // j ist der index des vorherigen Elements
            int j = i - 1;
            // temp ist das aktuelle element welches angesehen wird
            int temp = nums[i];
            zuweisungen++;

            // Sobald das Element links von Temp größer ist, wird es nach rechts bewegt
            vergleiche++;
            while(j >= 0 && nums[j] > temp){
                vergleiche++;
                // beweg ein element nach rechts
                nums[j + 1] = nums[j];
                zuweisungen++;
                j--;
            }
            // While stoppt an einer Position bei der ein Element nicht größer ist
            // als die Temp oder im negativen ist. Daher ist die Korrekte position eins rechts davon
            nums[j+1] = temp;
            zuweisungen++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,6,7,9,48,6,5,2,4,3,2,5,6,4,8,5,6,4,2,3,12,5,6};

        insertionSearch(nums);

        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println("\nZuweisungen: " + InsertionSearch.zuweisungen);
    
        int[] randArr = new int[1000];
        
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            randArr[i] = r.nextInt(1000) + 1; // 1–1000
        }

        insertionSearch(randArr);

        System.out.println("-----------------------------------\n"+
                            Arrays.toString(randArr)+"\n"+
                            "----------------------------------\n");
        System.out.println("Zuweisungen = "+ InsertionSearch.zuweisungen);
        System.out.println("Vergleiche = "+ InsertionSearch.vergleiche);

    }
}
