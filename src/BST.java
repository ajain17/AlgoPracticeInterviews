import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node next;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        next = null;
    }

    @Override
    public String toString(){
        return String.valueOf(data);// + " -> " + right);
    }

}
public class BST{
    public static Node root;
    public void display(Node root)
    {

    }
    public void insert(int id)
    {
        System.out.println("inserting " + id);
        Node node = new Node(id);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        Node parent = null;

        while (current!=null) {
            parent=current;
            if (id<current.data) {
                current=current.left;
                if (current==null) {
                    parent.left=node;
                    return;
                }
            }
            else{
                //parent=current;
                current = current.right;
                if (current==null) {
                    parent.right=node;
                    return;
                }
            }
        }
    }

    public boolean delete(int id)
    {
        return true;//choose minimum element from the right subtree if node has 2 children
    }
    public boolean find(int id)
    {
        return true;
    }
    public void preorder(Node root){
        System.out.println(root.data);
        if (root.left!=null) preorder(root.left);
        if (root.right!=null) preorder(root.right);

    }
    public void postorder(Node root){
        if (root.left !=null) postorder(root.left);
        if (root.right!=null) postorder(root.right);
        System.out.println(root.data);
    }

    public void inorder(Node root){
        if (root.left!=null) inorder(root.left);
        System.out.print(root.data + " ");
        if (root.right!=null) inorder(root.right);
    }

    public boolean checkBST(Node root) {
        List<Integer> arr= new ArrayList();
        arr = getInorder(root, arr);
        System.out.println(arr);
        for(int i=1;i<arr.size();i++)
        {
            if (arr.get(i-1) > arr.get(i))
                return false;
        }
        return true;
    }

    public int isSymmetric(Node a) {
        Node root = a;
        if(a.left == null && a.right == null)
            return 1;
        if((a.left == null && a.right!=null) || (a.left!=null & a.right == null))
            return 0;
        ArrayList<Integer> leftSide = new ArrayList<>();
        ArrayList<Integer> rightSide = new ArrayList<>();
        leftSide = inorder(a.left, leftSide);
        rightSide = inorder(a.right, rightSide);
        if(leftSide.size() != rightSide.size())
            return 0;
        int length = leftSide.size()-1;
        for(int i = 0; i <= length; i++) {
            if(leftSide.get(i) != rightSide.get(length-i))
                return 0;
        }
        return 1;
    }

    public void printAllPaths(Node node, int path[], int pathLen)
    {
        if (node == null)
            return;

        /* append this node to the path array */
        path[pathLen] = node.data;
        pathLen++;

        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            /* otherwise try both subtrees */
            printAllPaths(node.left, path, pathLen);
            printAllPaths(node.right, path, pathLen);
        }
    }

    //manipulates original arraylist results that will give us the answer.
    public void pathsUsingDfs(Node root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> curr){
        curr.add(root.data);

        if(root.left==null && root.right==null){
            list.add(curr);
            return;
        }

        if(root.left!=null){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            pathsUsingDfs(root.left, list, temp);
        }

        if(root.right!=null){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            pathsUsingDfs(root.right, list, temp);
        }
    }


    //Diameter is max of:
    // longest path between two nodes that passes through root node
    // diameter of left subtree
    // diameter of right subtree
    public void diameter(Node node, ArrayList<Integer> lengths, int currLength){
        if( node == null)
            return;
        if(node.left==null && node.right==null)
        {
            lengths.add(currLength+1);
            return;
        }
       // diameter(node.left, lengths, currLength+1) + diameter(node.right,lengths,currLength+1);
    }

    //height of a tree is the number of edges from the node to the deepest leaf.
    int height(Node a){
        if(a == null)
            return 0;
        return (1+Math.max(height(a.left),height(a.right)));
    }

    void printArray(int ints[], int len)
    {
        int i;
        for (i = 0; i < len; i++)
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

    void getNodesOnALevel(ArrayList<Node> result, Node node, int level) {
        if(node == null) {
            return;
        }
        if(level == 0) {
            result.add(node);
            return;
        }
        if(level > 0) {
            getNodesOnALevel(result,node.left, level-1);
            getNodesOnALevel(result,node.right, level-1);
        }

    }

    void populateRightPointers(){
        int level = 0;
        if(root == null)
            return;

        //ArrayList<ArrayList<Node>> result = new ArrayList<>();
        ArrayList<Node> nodesAtLevel;
        int max = height(root);
        for(level=0; level<max;level++) {
            nodesAtLevel = new ArrayList<>();
            getNodesOnALevel(nodesAtLevel, root, level);
            System.out.println(nodesAtLevel);
            for(int i = 0; i < nodesAtLevel.size(); i++ ) {
                if((i+1)==nodesAtLevel.size()) {
                    nodesAtLevel.get(i).next = null;
                }
                else {
                    nodesAtLevel.get(i).next = nodesAtLevel.get(i+1);
                }
            }
            for(Node x : nodesAtLevel) {
                System.out.println(x.data + " -> "+ x.next);
            }
        }
        System.out.println("******");
        printLevelOrder();
    }

    void printLevelOrder(){
        ArrayList<Node> nodes;
        int max = height(root);
        int level;
        for(level=0; level<max;level++) {
            nodes = new ArrayList<>();
            getNodesOnALevel(nodes, root, level);
            System.out.println(nodes);
            for(Node x: nodes){
                System.out.print(x.data+ "->" + x.next + "\t");
            }
            System.out.println();
        }
    }

    public ArrayList<Integer> getAllChildren(Node current) {
        ArrayList<Integer> children = new ArrayList<>();
        children.ensureCapacity(2);
        if(current.left!=null)
            children.add(current.left.data);
        if(current.right!=null)
            children.add(current.right.data);
        return children;
    }

    public ArrayList<Integer> inorder(Node a, ArrayList<Integer> list){
        if(a.left!=null) inorder(a.left, list);
        list.add(a.data);
        if(a.right!=null) inorder(a.right, list);
        return list;
    }

    List getInorder(Node root, List arr){
        if(root.left!=null) getInorder(root.left,arr);
        arr.add(root.data);
        if(root.right!=null) getInorder(root.right,arr);
        return arr;
    }

    public static void main(String args[]){
        BST b = new BST();
        b.insert(12);
        b.insert(4);
        b.insert(1);
        b.insert(6);
        b.insert(14);
        b.insert(0);
        b.insert(11);
        b.insert(21);
        b.insert(13);
        System.out.println("insertion done");
        /*System.out.println("POSTORDER");
        b.postorder(root);
        System.out.println("PREORDER");
        b.preorder(root);*/
        //System.out.println("INORDER");
        //b.inorder(root);
        ArrayList<Integer> arr = new ArrayList<>();
        //int[] path = new int[20];
        //System.out.println(b.getInorder(root,arr));
        //b.printAllPaths(root,path, 0);
        //System.out.println(b.checkBST(root));

        //ArrayList<Integer> curr = new ArrayList<>();
        //ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        //b.pathsUsingDfs(root, results, curr);
        //System.out.println(results);

        //System.out.println(b.height(root));
        //ArrayList<Node> allNodes = new ArrayList<>();
        //b.getNodesOnALevel(root,0);
        //b.getNodesOnALevel(root,1);
        //b.getNodesOnALevel(root,2);
        //b.getNodesOnALevel(allNodes, root,1);
        //System.out.println(allNodes);
        b.populateRightPointers();

    }

}