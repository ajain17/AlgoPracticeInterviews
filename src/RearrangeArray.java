import java.util.Arrays;

/**
 * Created by ayushij on 1/29/17.
 */
public class RearrangeArray {
    static int[] arr = {4,2,0,1,3};
    public static  void main(String args[]){
        rearrange();
    }

    private static void rearrange(){
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        for(int i = 0; i< n;i++){
          arr[i] += ((arr[arr[i]]%n)*n);
        }
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i<n; i++){
            arr[i] /= n;
        }
        System.out.println(Arrays.toString(arr));

    }
}

