import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 1/9/17.
 */
public class ShortestPrefix {
    private class Node{
        char key;
        String value;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String args[]){
        ArrayList<String> input = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ShortestPrefix prefix = new ShortestPrefix();
        System.out.println(prefix.getPrefix(input));
    }

    public ArrayList<String> getPrefix(ArrayList<String> input){
        Node root = new Node();
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i< input.size(); i++){
            String currentKey = input.get(i);

        }
        return result;
    }
}
