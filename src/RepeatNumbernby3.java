/**
 * Created by ayushij on 12/19/16.
 *
 You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

 If so, return the integer. If not, return -1.

 If there are multiple solutions, return any one.

 Example :

 Input : [1 2 3 1 1]
 Output : 1
 1 occurs 3 times which is more than 5/3 times.
 */
import java.util.*;

public class RepeatNumbernby3 {
    // DO NOT MODIFY THE LIST
    //no constant space
    public static int repeatedNumber(final List<Integer> a) {
        double threshold = a.size()/3;
        System.out.println(threshold);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < a.size(); i++) {
            int element = a.get(i);
            if(map.containsKey(element))
                map.put(element, map.get(element)+1);
            else
                map.put(element, 1);
            if(map.get(element) > threshold)
                return element;
        }
        return -1;
    }


    //constant space, nlgn time
    public static int repeatedNumber2(final List<Integer> a){
        double threshold = a.size()/3;
        Collections.sort(a);
        for(int i = 0; i < a.size();){
            int num = a.get(i);
            int frequency = 0;
            while(i<a.size() && a.get(i)==num){
                frequency++;
                i++;
            }
            if(frequency>threshold){
                return num;
            }
        }
        return -1;

    }

    public static void main(String args[]){
        List<Integer> a = Arrays.asList( 1000441, 1000441, 1000994 );
        System.out.println(repeatedNumber(a));
        //System.out.println(repeatedNumber2(a));
    }
}
