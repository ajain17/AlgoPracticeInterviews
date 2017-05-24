/**
 * Created by ayushij on 11/6/16.
 */
import java.util.*;

public class firstNonRepeating {
    public static void main(String args[]){
        firstNonRepeating obj = new firstNonRepeating();
        String input = "saksham";
        Map<Character,Integer> myMap = new LinkedHashMap<>();
        for(char ch: input.toCharArray()){
            if(myMap.containsKey(ch)){
                myMap.put(ch, myMap.get(ch)+1);
            }
            else
                myMap.put(ch,1);
        }
        Iterator i = myMap.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry pair = (Map.Entry) i.next();
            if ((int)pair.getValue() == 1) {
                System.out.print(pair.getKey());
                break;
            }
        }

    }
}
