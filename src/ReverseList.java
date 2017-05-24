/**
 * Created by ayushij on 11/1/16.
 */
public class ReverseList {

    private class Node {
        Node next;
        int val;
        Node(int val){
            this.val = val;
            next = null;
        }
    }

    Node root = null;

    public void insert(int n) {
        Node temp = new Node(n);
        temp.next = null;
        if(root == null)
            root = temp;
        else{
            Node currNode = root;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = temp;
        }
    }

    public void printList(){
        if(root == null){
            System.out.println("nothing to print");
        }
        Node currNode = root;
        System.out.println();
        while(currNode != null){
            System.out.print(currNode.val);
            System.out.print("-->");
            currNode = currNode.next;
        }
    }

    public void reverseList(){
        if ( root == null){
            System.out.println("nothing to reverse");
        }
        Node prev = null;
        Node curr = root;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        root = prev;
    }
    public static void main(String args[]){
        ReverseList obj = new ReverseList();
        obj.insert(5);
        obj.insert(10);
        obj.insert(40);
        obj.insert(30);
        obj.insert(20);
        obj.insert(50);
        obj.printList();
        obj.reverseList();
        obj.printList();

    }



}
