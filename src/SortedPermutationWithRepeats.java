/**
 * Created by ayushij on 1/28/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ayushij on 1/28/17.
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
 Assume that no characters are repeated.

 */
public class SortedPermutationWithRepeats {
   private int[] count;
    public static void main(String args[]){
        SortedPermutationWithRepeats obj = new SortedPermutationWithRepeats();
        String input = "CAAA";
        obj.noOfSmallerCharacters(input);
        System.out.println(obj.rank(input));
    }

    private long rank(String input){
        long rank = 1;
        int noOfSmallerChars, remainingChars;
        int currentIndex = 0;

        for(char x: input.toCharArray()){
            ++currentIndex;
            System.out.println(count[(int)x]);
            noOfSmallerChars = count[(int)x];
            remainingChars = input.length()-currentIndex;
            System.out.println(noOfSmallerChars + " * "+ factorial(remainingChars));
            rank += noOfSmallerChars * factorial(remainingChars);
            System.out.println("rank is" + rank);
            decrementCount(x);
        }
        return rank%1000003;
    }

    private void decrementCount(char x){
        for(int i = (int)x; i<256; i++){
            --count[i];
        }
    }
    private long factorial(int n){
        if(n==0)
            return 0;
        long fact = 1;
        while(n>0) {
            fact *= n;
            n--;
        }
        return fact;
    }

    private void noOfSmallerCharacters(String input){
        count = new int[256];
        //put 1 for each present character

        for(char x: input.toCharArray()){
            count[(int)x] = 1;
        }
        //update the count of how many chars are smaller than this char
        for(int i = 1; i<256; i++){
            count[i] += count[i-1];
        }
        for(int i = 1; i < 256; i++){
            --count[i];
        }
    }

}
