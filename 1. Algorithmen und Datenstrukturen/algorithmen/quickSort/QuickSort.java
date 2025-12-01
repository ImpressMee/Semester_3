
package quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * Quicksort:
 * Teilt das Array in kleinere Bereiche auf (Divide & Conquer).
 * 1. Pivot wählen.
 * 2. Alles kleiner als Pivot nach links, alles größere nach rechts.
 * 3. Links und rechts rekursiv weitersortieren.
 */

public class QuickSort {

    private static int zuweisungen = 0; // zählt Array-Schreiboperationen
    private static int vergleiche = 0;

    private static void reset(){
        zuweisungen = 0;
        vergleiche = 0;
    }

    // Sortiert den Bereich nums[start ... end]
    private static void quicksort(int[] nums, int start, int end){
        
        if(end <= start) return; // Wenn Bereich 0 oder 1 Element → fertig

        int pivot = partition(nums, start, end); // Array um den Pivot aufteilen
        
        quicksort(nums, start, pivot - 1); // linker Teil
        quicksort(nums, pivot + 1, end);   // rechter Teil
    }

    // Teilt den Bereich in < Pivot und > Pivot auf und gibt Pivot-Index zurück
    private static int partition(int[] nums, int start, int end){

        int pivot = nums[end]; // Pivot ist das letzte Element
        int j = start - 1;     // Grenze zwischen Pivot-Bereich und Rest
        int temp;

        // Alle Elemente im Bereich ansehen
        for(int i = start; i <= end - 1; i++){

            // Wenn Element kleiner als Pivot -> nach links
            if(nums[i] < pivot){
                vergleiche++;
                j++; // Grenze verschieben

                // Swap: tauscht nums[i] mit nums[j]
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                zuweisungen += 3; // drei Schreibzugriffe
            }
        }

        // Pivot an die richtige Stelle setzen
        j++;
        temp = nums[j];
        nums[j] = nums[end];
        nums[end] = temp;
        zuweisungen += 3;

        return j; // endgültige Pivot-Position
    }
    
    public static void main(String[] args) {
        
        
        int[] nums = {1,5,4,7,89,6,5,4,7,5,3,2,1,5,6,5,6,4,2,4,3,1,5};

        System.out.println(Arrays.toString(nums));
        
        reset(); // setzt die zuweisungen auf 0
        quicksort(nums, 0, nums.length-1);

        System.out.println("---------QUICKSORTED--------------");
        System.out.println(Arrays.toString(nums));
        System.out.println("zuweisungen: " + QuickSort.zuweisungen);

        System.out.println("---------RANDOM NUMS--------------");

        int[] randArr = new int[1000];
        
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            randArr[i] = r.nextInt(1000) + 1; // 1–1000
        }

        reset();
        quicksort(randArr, 0, randArr.length-1);

        System.out.println("-----------------------------------\n"+
                            Arrays.toString(randArr)+"\n"+
                            "----------------------------------\n");
        System.out.println("Zuweisungen = "+ QuickSort.zuweisungen);
        System.out.println("Vergleiche = "+ QuickSort.vergleiche);

    }
}