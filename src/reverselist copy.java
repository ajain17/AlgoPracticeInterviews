/**
 * Created by ayushij on 10/2/16.
 */
public class reverselist {
    static Node root;
    public static void main(String args[]){
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        printlist(root);
        Node currroot= reverselist();
        printlist(currroot);
    }

    public static void insert(int val){
        if(root==null){
            root=new Node(val);
            root.next=null;
        }
        else{
            Node newnode=new Node(val);
            Node curr=root;
            if(curr.next==null){
                curr.next=newnode;
                return;
            }
            while(curr.next!=null){
                curr=curr.next;
            }
            System.out.println("inserting after curr" + curr.data);
            curr.next=newnode;
            newnode.next=null;
        }
    }
    public static Node reverselist(){
        Node prev=root;
        Node curr=prev.next;
        root.next=null;
        while(prev!=null && curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static void printlist(Node currroot){
        Node curr=currroot;
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }

}

class Node{
    Node next;
    int data;
    Node(int data){
        this.data=data;
        next=null;
    }
}
