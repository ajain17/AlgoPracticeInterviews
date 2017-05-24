import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 1/5/17.
 */
public class LengthOfLargestContiguousSubsequence {

    public static void main(String args[]) {
        List<Integer> a = Arrays.asList(9, 30, 50);
        //System.out.println(largestNumber(a));
        LengthOfLargestContiguousSubsequence o = new LengthOfLargestContiguousSubsequence();
        int[] arr = {3,1,2};//{1,3,2,4,5,3};
        //System.out.println(repeatedNumber2(a));
        System.out.println(o.calculateSubsequence(arr));
    }

    int calculateSubsequence(int[] arr) {
        int maxLen = 0, startIndex = -1;
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr.length;
        int i; //  < 2
        for (i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) {
                maxLen = Math.max(maxLen, (i - startIndex));
                startIndex = i;
            }
        }
        System.out.println(i);
        if (arr[i] > arr[i-1]){
            maxLen = Math.max(maxLen, i - startIndex);
        }

        return maxLen;
    }
}
