import java.util.Arrays;
import java.util.*;

/**
 * Created by ayushij on 12/22/16.
 * Given an array A of integers and another non negative integer k,
 * find if there exists 2 indices i and j such that
 * A[i] - A[j] = k, i != j.
 */
public class IndicesWithDiffK {
    public static void main(String args[]){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        System.out.println("list is " + a);
        int k = 2;

        Set<Integer> set = new HashSet<>(a);
        System.out.println("set is " + set);
        for(int element: a)
            set.add(element);
        for( int x: set) {
            if(set.contains(x+k)){
                System.out.println(1);
                break;
            }
        }
        System.out.println(0);
    }
}
