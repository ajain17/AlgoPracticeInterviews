import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayushij on 12/28/16.
 */
public class PascalsSimple {
    public static void main(String args[]){
        PascalsSimple obj = new PascalsSimple();
        System.out.print(obj.getRow(4));
    }
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>();

        if (rowIndex < 0)
            return result;
        result.add(1);
        for(int i = 1; i<=rowIndex;i++) {
            for(int j = result.size()-2; j>=0; j--){
                result.set(j+1, result.get(j) + result.get(j+1));
            }
            result.add(1);
        }
        return result;
    }
}
