import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ayushij on 1/2/17.
 */
public class AllSubsetsOfSet {
    public static void main(String args[]) {
        ArrayList<Integer> mySet = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        AllSubsetsOfSet allSubsetsOfSet = new AllSubsetsOfSet();
        //System.out.println(allSubsetsOfSet.findPermutations(mySet));
        char[] set = {'a', 'b', 'c'};
        allSubsetsOfSet.printSubsets(set);
    }


    //gives only in order subsets
    public ArrayList<ArrayList<Integer>> findPermutations(ArrayList<Integer> mySet) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < mySet.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j < mySet.size(); j++) {
                ArrayList<Integer> temp1 = new ArrayList<>(temp);
                temp.add(mySet.get(j));
                temp1.add(mySet.get(j));
                result.add(temp1);
            }
        }
        return result;
    }

    public void printSubsets(char set[]) {
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
