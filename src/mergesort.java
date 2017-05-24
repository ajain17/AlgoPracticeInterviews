/**
 * Created by ayushij on 10/2/16.
 */
import java.util.*;
public class mergesort {

    public static void main(String [] args){
        int [] arr = { 9,3,6,2,6,5,7,1};
        arr = dividearray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] dividearray(int [] arr)
    {
        int n=arr.length;
        if(n<=1){
            return arr;
        }
        int mid=n/2;
        int[] left= new int[mid];
        int[] right= new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }
        System.out.println(Arrays.toString(left));
        for(int i=mid;i<n;i++){
            right[i-mid]=arr[i];
        }
        System.out.println(Arrays.toString(right));
        dividearray(left);
        dividearray(right);
        mergearray(left,right,arr);
        return arr;
    }
    public static void mergearray(int[] first, int[] second, int[] result){
        //System.out.println(first);
        int i=0,j=0,k=0;
        while(i<first.length && j<second.length) {
            if (first[i] < second[j]) {
                result[k++] = first[i++];
            } else {
                result[k++] = second[j++];
            }
        }
        while(i<first.length){
            result[k++]=first[i++];
        }
        while(j<second.length){
            result[k++]=second[j++];
        }
        System.out.println("merged");
        for(int x : result){
            System.out.print(x);
        }
        System.out.println();
    }
}
