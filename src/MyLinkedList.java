/**
 * Created by ayushij on 2/27/17.
 */
import java.util.LinkedList;
public class MyLinkedList {
    LNode root;
    public static void main(String args[]){
        MyLinkedList obj = new MyLinkedList();
        obj.insertNode(1);
        obj.insertNode(2);
        obj.insertNode(3);
        obj.insertNode(4);
        obj.insertNode(5);
        obj.insertNode(6);
        obj.insertNode(16);

        obj.printList();
        obj.compress(3);
        obj.printList();
//        obj.printBackwards(obj.root);

    }

    private void compress(int n){
            LNode current = root;
            LNode previous = current;
            int i = 0;
            int sum = 0;
            while(current.next!=null){
                sum+=current.val;
                i++;
                if(i==n){
                    previous.val = sum;
                    previous = previous.next;
                    i = 0;
                    sum = 0;
                }
                current = current.next;
            }
            sum+=current.val;
            previous.val = sum;
            previous.next = null;
    }
    private void printList(){
        LNode curr = root;
        while(curr.next!=null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }

    private void insertNode(int x){
        if(root == null){
            root = new LNode(x);
            return;
        }
        LNode curr = root;
        while(curr.next!=null){
            curr = curr.next;
        }
        LNode temp = new LNode(x);
        curr.next = temp;
        return;
    }

    private void printBackwards(LNode node){
        if(node.next!=null)
            printBackwards(node.next);
        System.out.println(node.val);
    }
}

class LNode{
    LNode next;
    int val;
    LNode(int val)
    {
        this.val=val;
        this.next = null;
    }
}
