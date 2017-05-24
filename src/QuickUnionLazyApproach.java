import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ayushij on 1/7/17.
 *
 * Find: if root of x == root of y
 * Union: set root of x = root of y
 * Complexity: Union: N array acccesses. IF trees get tall, find gets too expensive
 */
public class QuickUnionLazyApproach {
    private int[] id;
    private int[] size;
    public static void main(String args[]) {
        QuickUnionLazyApproach unionFindLazy = new QuickUnionLazyApproach();
        System.out.println("Enter the number of pairs");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        unionFindLazy.doUnionFind(n);
    }

    private void doUnionFind(int n) {
        id = new int[n];
        size = new int[n];
        for(int x = 0; x < n; x++) {
            id[x]=x;
        }
        for(int x = 0; x < n; x++) {
            size[x]=1;
        }
        int i = 1;
        while(i<=n) {
            System.out.println("Enter pair " + i);
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(!isConnected(x,y)) {
                System.out.println("Calling union");
                unionWeighted(x,y);
            }
            System.out.println(Arrays.toString(id));
        }
        System.out.println(Arrays.toString(id));
    }

    //find function : check if parent of x and parent of y are same
    //will have to traverse at max lg n nodes (where log n is depth).
    private boolean isConnected(int x, int y) {
       return root(x) == root(y);
    }

    private int root(int x) {
        while(id[x]!=x) {
            id[x] = id[id[x]]; //set its parent to the grand parent.
            x = id[x];
        }
        return x;
    }

    //complexity: log(n)
    private void unionEager(int x, int y){
        //set root of x equal to root of y so now its a child of y's root
        id[root(x)] = id[root(y)];
    }

    //this joins the smaller tree below larger tree to avoid tall trees
    private void unionWeighted(int x, int y){
        int i = root(x);
        int j = root(y);
        if(size[i] < size[j]){
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }
}
