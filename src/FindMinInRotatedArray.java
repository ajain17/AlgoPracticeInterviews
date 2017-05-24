import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 2/11/17.
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.
 */
public class FindMinInRotatedArray {
    public static void main(String args[]){
        FindMinInRotatedArray obj = new FindMinInRotatedArray();
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(0);
        a.add(1);
        a.add(2);
        //obj.findMin(a);
        final int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 4;
        arr[2] = 3;
        final int x = 4;
        System.out.println(Arrays.toString(arr));
    }
/*
    public int findMin(final List<Integer> a) {
        int low = 0; int high = a.size()-1;
        
        return -1;
    }
*/
}
