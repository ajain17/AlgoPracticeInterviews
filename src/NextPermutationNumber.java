import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 12/19/16.
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

 If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

 The replacement must be in-place, do not allocate extra memory.

 Examples:

 1,2,3 → 1,3,2

 3,2,1 → 1,2,3

 1,1,5 → 1,5,1

 20, 50, 113 → 20, 113, 50
 */
import java.util.*;
public class NextPermutationNumber {

    public void nextPermutation(ArrayList<Integer> a) {
        ArrayList<Integer> temp;
        boolean found = false;
        for(int i = a.size()-1; i>0;i--){
            temp = swap(a,i,i-1);
            System.out.println("orig" + a);
            System.out.println("temp is" + temp);
            long num1 = getNumber(temp);
            long num2 = getNumber(a);
            System.out.println("temp no" + num1 + " original no is " + num2);
            if(getNumber(temp) > getNumber(a)){
                found = true;
                System.out.println("found permutation");
                System.out.println(temp);
                break;
            }
        }
        if(!found){
            Collections.sort(a);
            System.out.println(a);
        }
    }

    private long getNumber(ArrayList<Integer> a){
        StringBuilder sb = new StringBuilder();
        for(int x : a){
            sb.append(x);
        }
        return Long.valueOf(sb.toString());
    }
    private ArrayList<Integer> swap(ArrayList<Integer> a, int i, int j){
        ArrayList<Integer> result = new ArrayList(a);
        int temp = result.get(i);
        result.set(i, result.get(j));
        result.set(j,temp);
        return result;
    }

    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        NextPermutationNumber obj = new NextPermutationNumber();
        obj.nextPermutation(a);
    }
}
