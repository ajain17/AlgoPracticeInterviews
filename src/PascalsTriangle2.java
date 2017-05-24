import java.util.ArrayList;

/**
 * //starting row is 0
 * Created by ayushij on 12/28/16.
 */
public class PascalsTriangle2{

    public static void main(String args[]){
        PascalsTriangle2 obj = new PascalsTriangle2();
        System.out.print(obj.printNthRow(4));
    }

    public ArrayList<Integer> printNthRow(int n) {
        ArrayList<Integer> currRow = new ArrayList<>();
        ArrayList<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if(n == 0)
            return prevRow;
        prevRow.add(1);
        if(n == 1)
            return prevRow;
        for(int i=2; i<=n; i++) {
            currRow.clear();
            currRow.add(0,1);
            for(int j=0;j<i-1;j++){
                currRow.add(j+1, prevRow.get(j) + prevRow.get(j+1));
            }
            currRow.add(i,1);
            prevRow = new ArrayList<>(currRow);
        }
        return currRow;
    }
}
