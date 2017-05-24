import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ayushij on 1/7/17.
 * Dynamic Connectivity
 * //Complexity: Union: O(n) find O(1) for n elements, union is N^2;
 * This is eager approach.
 */
public class UnionFindEager {
    private int[] id;

    public static void main(String args[]) {
        UnionFindEager unionFindEager = new UnionFindEager();
        System.out.println("Enter the number of pairs");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        unionFindEager.doUnionFind(n);
    }

    private void doUnionFind(int n) {
        id = new int[n];
        for(int x = 0; x < n; x++) {
            id[x]=x;
        }
        int i = 1;
        while(i<=n) {
            System.out.println("Enter pair " + i);
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(!isConnected(x,y)){
                System.out.println("Doing union");
                union(x,y);
            }

            System.out.println(Arrays.toString(id));
        }
        System.out.println(Arrays.toString(id));
    }
    private boolean isConnected(int x, int y) {
        return id[x] == id[y];
    }

    private void union(int x, int y){
        //put value of x index in y to show they are connected
        int firstID = id[x];
        int secondId = id[y];
        for(int i = 0; i<id.length;i++){
            if(id[i] == firstID)
                id[i] = secondId;
        }
    }
}
