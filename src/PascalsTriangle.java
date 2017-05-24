import java.util.ArrayList;

/**
 * //starting row is 1
 * Created by ayushij on 12/28/16.
 */
public class PascalsTriangle {

    public static void main(String args[]){
        PascalsTriangle obj = new PascalsTriangle();
        System.out.print(obj.printNthRow(3));
    }

    public ArrayList<Integer> printNthRow(int n) {
        ArrayList<Integer> currRow = new ArrayList<>();
        ArrayList<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if(n == 1)
            return prevRow;
        prevRow.add(1);
        if(n == 2)
            return prevRow;
        for(int i=3; i<=n; i++) {
            currRow.clear();
            currRow.add(0,1);
            for(int j=0;j<i-2;j++){
                currRow.add(j+1, prevRow.get(j) + prevRow.get(j+1));
            }
            currRow.add(i-1,1);
            prevRow = new ArrayList<>(currRow);;
        }
        return currRow;
    }
}
