/**
 * Created by ayushij on 1/9/17.
 */
public class Tries<Value> {
    private static final int R = 256;
    private Node root = new Node();
    private static class Node{
        private Object value; //use object instead of value since no generic array creation in java
        private Node[] next = new Node[R];
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);      //returns the reference to the trie it creates
    }

    private Node put(Node x, String key, Value val, int d){
        if(x == null) x = new Node();
        if(d == key.length()) { x.value = val; return x;}
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Value get(String key){
        Node x = get(root, key,0);
        if (x == null) return null;
        return (Value)x.value;

    }

    private Node get(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        x = get(x.next[c], key, d+1);
        return x;
    }

    public boolean contains(String key){
        return !(get(key) == null);
    }
}
