import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ayushij on 1/15/17.
 */
public class Sorting {
    public static void main(String args[]){
        Sorting sorting = new Sorting();
        int[] arr = {7,6,2,3,4,1,5};
        sorting.insertionSort(arr);
        System.out.println(sorting.isPrime(2));

    }

    private void insertionSort(int[] arr) {
        System.out.println("received " + Arrays.toString(arr));
        int j; int temp;
        for(int i = 0; i< arr.length; i++) {
            j = i;
            while(j>0 && arr[j]<arr[j-1]){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
            }
        }
        System.out.println("sorted " + Arrays.toString(arr));
    }

    boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n>2 && n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
