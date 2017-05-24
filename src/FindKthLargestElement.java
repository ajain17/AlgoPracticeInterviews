import java.util.Arrays;

/**
 * Created by ayushij on 1/22/17.
 */
public class FindKthLargestElement {
    static int[] arr = {3, 2, 1, 7, 4, 6, 5};
    public static void main(String args[]){
        FindKthLargestElement obj = new FindKthLargestElement();
        QuickSort sorting = new QuickSort();
        arr = sorting.shuffle(arr);
        System.out.println("Shuffled array is " + Arrays.toString(arr));
        //indexing starts from 0.
        //System.out.println(obj.findKthLargest(arr, 0, arr.length-1, 0));
        System.out.println(obj.findKthLargest2(arr, 0, arr.length-1, 1));
    }

    //starting index 0 for k
    private int findKthLargest(int[] arr, int lo, int hi, int k){
        while(hi>lo){
            int j = partition(arr, lo, hi);
            if(j==k)
                return arr[k]; //this is our partition element
            if (j < k) //element is in right side
            {
                lo = j+1;
            } else if (j > k) {
                hi = j-1;
            }
        }
        System.out.println("outside");
        return arr[k];
    }

    //starting index 1 for k
    private int findKthLargest2(int[] arr, int lo, int hi, int k){
        if(k<1 || k > arr.length)
            return -1;
        while(hi>lo){
            int j = partition(arr, lo, hi);
            System.out.println("sorted" + Arrays.toString(arr));
            System.out.println("partition element is " + j + "K is " + k);
            if(j==k-1)
                return arr[j]; //this is our partition element
            if (j < k) //element is in right side
            {
                lo = j+1;
            } else if (j > k) {
                hi = j-1;
            }
        }
        System.out.println("outside");
        return arr[k];
    }

    private int partition(int[] arr, int lo, int hi){
        int partition = arr[lo];
        int j = hi+1;
        int i = lo;
        while(true){
            while(i<hi && arr[++i] < partition);
            while(arr[--j] > partition);
            if(j<=i) //pointers crossed
                break;
            QuickSort.swap(arr, i ,j);
        }
        QuickSort.swap(arr, lo, j);
        return j;
    }
}
