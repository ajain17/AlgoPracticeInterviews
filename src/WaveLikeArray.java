/**
 * Created by ayushij on 12/22/16.
 * Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
Return lexicographically smaller array.
 */

import java.lang.reflect.Array;
import java.util.*;
public class WaveLikeArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        if(a.size() == 0 || a.size() == 1)
            return a;
        int temp = -1;
        for(int i = 1; i < a.size(); i++) {
            if(i%2 == 0 && a.get(i) < a.get(i-1)) {
                temp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1, temp);
                //swap
            }
            if(i%2 == 1 && a.get(i) > a.get(i-1)) {
                //swap
                temp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1, temp);
            }
        }
        return a;
    }

    //o(n) time solution
    public ArrayList<Integer> waveEfficient(ArrayList<Integer> a) {
        a = findSecondSmallestNumber(a);
        int temp = -1;
        System.out.println("working with" + a);
        for(int i = 1; i < a.size(); i++) {
            if(i%2 == 0 && a.get(i) < a.get(i-1)) {
                temp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1, temp);
                //swap
            }
            if(i%2 == 1 && a.get(i) > a.get(i-1)) {
                //swap
                temp = a.get(i);
                a.set(i, a.get(i-1));
                a.set(i-1, temp);
            }
        }
        return a;
    }

    private ArrayList<Integer> findSecondSmallestNumber(ArrayList<Integer> a) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for( int x : a) {
            if (x < smallest) {
                secondSmallest = smallest;
                smallest = x;
            } else if (x < secondSmallest) {
                secondSmallest = x;
            }

        }
        a.remove((Integer)smallest);
        a.remove((Integer)secondSmallest);
        a.add(0, secondSmallest);
        a.add(1, smallest);
        return a;
    }
    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList( 5, 1, 3, 2, 4 ));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList( 5, 1, 3, 2, 4 ));
        WaveLikeArray obj = new WaveLikeArray();
        System.out.println("non efficient" + obj.wave(a));
        System.out.println(" efficient " + obj.waveEfficient(b));
    }

}
