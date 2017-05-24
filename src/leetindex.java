/**
 * Created by ayushij on 10/2/16.
 */

import java.util.*;

public class leetindex {
    public static void main(String args[]){
        leetindex obj = new leetindex();
        int[] arr = {13,10,1,14,5,16,7,9,11};
        System.out.println("Array length is "+ arr.length);
        System.out.println("\nresult is " + obj.hIndex(arr));
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        System.out.println(Arrays.toString(citations));

        System.out.println("i    cit[i]   cit.len-i   smaller   result");
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            System.out.print(i+ "      " + citations[i] + "      ");
            System.out.print(citations.length-i+"               "+ smaller+ "         ");
            result = Math.max(result, smaller);
            if(citations[i]>citations.length-i){
                break;
            }
            System.out.println(result);
        }

        return result;
    }
}
