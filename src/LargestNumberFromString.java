import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 12/19/16.
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 */

import java.util.*;
public class LargestNumberFromString {

    public static String largestNumber(final List<Integer> nums) {
        System.out.println(nums);
        String[] arr = new String[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = String.valueOf(nums.get(i));
        }

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return sb.toString();
    }


    public static void main(String args[]) {
        List<Integer> a = Arrays.asList(9, 30, 50);
        //System.out.println(largestNumber(a));
        LargestNumberFromString o = new LargestNumberFromString();
        int[] arr = {3,1,2};//{1,3,2,4,5,3};
        //System.out.println(repeatedNumber2(a));
       // System.out.println(o.calculateSubsequence(arr));
    }
}
