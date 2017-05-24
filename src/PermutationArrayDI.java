/**
 * Created by ayushij on 12/20/16.
 * Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.
 D means the next number is smaller, while I means the next number is greater.
 Notes
 - Length of given string s will always equal to n - 1
 - Your solution should run in linear time and space.
 Example :
 Input 1:
 n = 3
 s = ID
 Return: [2, 3, 1]

 */
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class PermutationArrayDI {
    public ArrayList<Integer> findPerm(final String A, int n) {
        ArrayList<Integer> input = new ArrayList<>();
        int small = -1; int large = -1;
        input.ensureCapacity(n);
        for(int i = 1; i <= n; i++){
            input.add(i);
        }
        int index = 0;
        Matcher matcher;
        ArrayList<Integer> result = new ArrayList<>();

        Pattern d = Pattern.compile("D*");
        matcher = d.matcher(A);

        if(matcher.matches()){
            //return descending array
            for(int i = n; i >= 1; i--){
                result.add(i);
            }
            return result;
        }

        Pattern i = Pattern.compile("I*");
        matcher = i.matcher(A);
        if(matcher.matches()){
            //return ascending array
            for(int x = 1; x <= n; x++){
                result.add(x);
            }
            return result;
        }
        while(input.size()>1 && index < n){
            System.out.println("char is " + A.charAt(index) + " t index" + index);
            System.out.println("input is" + input);
            if(A.charAt(index) == 'D' || A.charAt(index) == 'd'){
                //next number is smaller so find the largest num
                large = secondLargest(input);
                System.out.println("largest is " + large);
                if(large>0) {
                    System.out.println("inside if small");
                    result.add(large);
                    input.remove((Integer)large);
                    System.out.println("now result is" + result);
                }
            } else if(A.charAt(index) == 'I' || A.charAt(index) == 'i'){
                System.out.println("inside if large");
                //next number is bigger so find the smallest num
                large = secondSmallest(input);
                System.out.println("largest is " + large);
                if(large!= -1)
                {
                    result.add(large);
                    input.remove((Integer)large);
                }
                System.out.println("now result is" + result);
            }
            index++;
        }
        result.add(input.get(0));
        System.out.println("returning " + result);
        return result;
    }

    private int secondSmallest(ArrayList<Integer> arr)
    {
        int first, second, arr_size = arr.size();

        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            return arr.get(0);
        }
        first =Integer.MAX_VALUE;
        for (int i = 0; i < arr_size ; i ++)
        {
            if (arr.get(i) < first)
            {
                first = arr.get(i);
            }
        }
        return first;
    }

    private int secondLargest(ArrayList<Integer> arr)
    {
        int first, second, arr_size = arr.size();

        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            return arr.get(0);
        }

        first = Integer.MIN_VALUE;
        for (int i = 0; i < arr_size ; i ++) {
            if (arr.get(i) > first) {
                first = arr.get(i);
            }
        }
        return first;
    }

    public static void main(String args[]){
        PermutationArrayDI obj = new PermutationArrayDI();
        String x = "DID";
        int n = 4;
        System.out.println(obj.findPerm(x,n));
    }

}
