/**
 * Created by ayushij on 10/2/16.
 */
import java.util.*;

public class Queue2Stacks {
    public static void main(String args[]){
        Stack<Integer> inbox = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        boolean selection=true;
        int num;
        do {
            System.out.println("enter 1 for insert 2 for delete");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("enter number to insert");
                    num=scanner.nextInt();
                    inbox.push(num);
                    System.out.println("Queue is now " + inbox.toString());
                    break;
                case 2:
                    if(inbox.isEmpty())
                        System.out.println("Nothing to delete");
                    else{
                        while(!inbox.isEmpty())
                            temp.push(inbox.pop());
                        System.out.println(temp.pop() + " deleted");
                        while(!temp.isEmpty())
                            inbox.push(temp.pop());
                        System.out.println("Queue is now " + inbox.toString());
                    }
                    break;
            }
            System.out.println("Do you want to continue? true/false");
            selection = scanner.nextBoolean();
        }while(selection==true);

    }
}
