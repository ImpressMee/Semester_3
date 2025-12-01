package mergeSort;

import java.util.Arrays;
import java.util.Random;


    /**
     * Adaptiver mergesort, galloping merge
     * O(n log n)
     * MergeSort, ein Divide und Conquer Algorithmus
     * Dabei wird ein großes Array in 2 kleine Arrays zerteils, und dieses dann wieder usw.
     * Bis am ende Arrays mit einem Wert drin stehen.
     * 
     * Ab diesem Punkt wird dann eine Hilfmethode merge() aufgerufen, welche diese kleinen Arrays
     * Sortiert zusammenfügt.
     * 
     * Am ende ist ein komplett sortiertes Array da.
     */

public class MergeSort {

    private static int zuweisungen = 0;
    private static int vergleiche = 0;

    private static void reset(){
        zuweisungen = 0;
        vergleiche = 0;
    }

    private static void mergeSort(int[] nums) {
        
        int size = nums.length;
        
        // stopp die rekursion
        if(size <= 1) return;

        // left and right sub-arrays
        int middle = size/2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[size - middle];

        // Zählvariablen für beide Subarrays
        int i = 0; // left Array
        int j = 0; // right Array

        // unsere zähl variable ist hier i. Wurde schon davor deklariert, muss man nicht extra machen
        for(; i < size; i++) {
            if(i < middle){
                leftArr[i] = nums[i];
                zuweisungen++;
            } else {
                rightArr[j] = nums[i];
                zuweisungen++;
                j++;
            }
        }
        mergeSort(leftArr); // Teile das Linke Array
        mergeSort(rightArr); // Teile das Rechte Array
        merge(leftArr, rightArr, nums); // Wenn beide Rekursionen fertig sind, füge zusammen
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] nums){
        int leftSize = nums.length/2;
        int rightSize = nums.length - leftSize;
        int i = 0; // position of original Array
        int l = 0; // position of left Array
        int r = 0; // position of right Array

        // Check the conditions for merging
        while(l < leftSize && r < rightSize){ // basically, while elements still exist
            vergleiche++;
            if(leftArr[l] < rightArr[r]){
                nums[i] = leftArr[l];
                i++;
                l++;
                zuweisungen++;
            } else {
                nums[i] = rightArr[r];
                i++;
                r++;
                zuweisungen++;
            }
        }
        // In case one element is left
        while(l < leftSize){
            nums[i] = leftArr[l];
            i++;
            l++;
            zuweisungen++;
        }
        while (r < rightSize) {
            nums[i] = rightArr[r];
            i++;
            r++;
            zuweisungen++;
        }

    }
    public static void main(String[] args) {
        
        int[] nums = {1,5,4,7,89,6,5,4,7,5,3,2,1,5,6,5,6,4,2,4,3,1,5};

        System.out.println(Arrays.toString(nums));
        
        reset(); // setzt die zuweisungen auf 0
        mergeSort(nums);

        System.out.println("---------MERGEDSORTED--------------");
        System.out.println(Arrays.toString(nums));
        System.out.println("zuweisungen: " + MergeSort.zuweisungen);

        System.out.println("---------RANDOM NUMS--------------");

        int[] randArr = new int[1000];
        
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            randArr[i] = r.nextInt(1000) + 1; // 1–1000
        }

        reset();
        mergeSort(randArr);

        System.out.println("-----------------------------------\n"+
                            Arrays.toString(randArr)+"\n"+
                            "----------------------------------\n");
        System.out.println("Zuweisungen = "+ MergeSort.zuweisungen);
        System.out.println("Vergleiche = "+ MergeSort.vergleiche);

    }
}