/**
 * Created by ayushij on 1/5/17.
 *
        1
      /  \
     2    3
    / \    \
   4   5    7

 *//*

public class RightPointersToNull {
    static Node root = null;
    public static void main(String args[]) {
        RightPointersToNull obj = new RightPointersToNull();
        obj.insertNode(root, 1);
    }

    void insertNode(Node node, int value) {
        if(root == null) {
            root = new Node(value);
            root.left = null;
            root.right = null;
        }
        Node curr = root;
        if (curr.left == null) {
            curr.left = new Node(value);
            return;
        } else if(curr.right == null) {
            curr.right = new Node(value);
            return;
        }
        insertNode(curr.left, value);
        insertNode(curr.right, value);
    }

    void printTree(){
        Node curr = root;
        while(curr.left!=null && )
    }
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;

        }

        @Override
        public String toString(){
            return ("Node " + data + " Left Child " + left.data + " Right child " + right.data);
        }
    }

}
*/