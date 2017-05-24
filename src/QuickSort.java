/**
 * Created by ayushij on 1/22/17.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    static int[] arr = {3, 2, 1, 7, 4, 6, 5};
    public static void main(String args[]){
        QuickSort sorting = new QuickSort();
        arr = sorting.shuffle(arr);
        System.out.println("Shuffled array is " + Arrays.toString(arr));
        sorting.quickSort(arr, 0, arr.length-1);
        System.out.println("sorted" + Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int lo, int hi){
        if(hi<=lo)
            return;
        int j = partition(arr, lo, hi);
        quickSort(arr, lo, j-1);
        quickSort(arr, j+1, hi);

    }

    public int partition(int[] arr, int lo, int hi) {
        int partition = arr[lo];
        int i = lo;
        int j = hi+1;
        while (true) {
            //while i < hi and arr[++i] < partition
            while (i < hi && arr[++i] < partition) ;
            while (arr[--j] > partition);
            //check if pointers crossed
            if (j <= i){
                break; //no need to swap i and j since pointers have crossed
                // and things are sorted. just sort with partition element
            }
            swap(arr, i, j);
        }
        swap(arr, j, lo); //swap the partition element with j
        return j;
    }

    public int[] shuffle(int[] arr){
        int randomIndex;
        for(int i = 0; i < arr.length; i++) {
            randomIndex = ThreadLocalRandom.current().nextInt(0,i+1);
            arr = swap(arr, i, randomIndex);
        }
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
