import java.util.Arrays;

/**
 * Created by ayushij on 1/4/17.
 */
public class MySorter {
    public static void main(String args[]) {
        Person users[] = new Person[4];
        Person p1 = new Person(110, "ayushi");
        Person p2 = new Person(180, "bleh");
        Person p3 = new Person(103, "anuja");
        Person p4 = new Person(150, "suyash");
        users[0] = p1;
        users[1] = p2;
        users[2] = p3;
        users[3] = p4;
        System.out.println(Arrays.toString(users));
        Arrays.sort(users);
        System.out.println(Arrays.toString(users));

    }
}

class Person implements Comparable<Person>
{
    int weight;
    String name;

    Person(int w, String n){
        weight = w;
        name = n;
    }
    // Comparator function used for sorting edges based on
    // their weigh
    // t
    @Override
    public int compareTo(Person friend)
    {
        System.out.println(this.weight);
        System.out.println(friend.weight);
        System.out.println(this.weight - friend.weight);
        System.out.println("******");
        return friend.weight-this.weight;
    }

    @Override
    public String toString(){
        return String.format(name + " " + weight);
    }
}