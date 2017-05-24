import java.util.ArrayList;

public class AntiDiagonals {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> thisRow ;
        int length = a.size()-1;
        int tempi = 0;
        int tempj=0;
        int i = 0;
        for(int j=0;j<=length;j++){
            thisRow = new ArrayList<>();
            tempj = j;
            tempi = i;
            while(tempi <= j && tempj >= i)
            {
                thisRow.add(a.get(tempi).get(tempj));
                tempi++;
                tempj--;
            }
            result.add(thisRow);
        }
        int j = length;
        for(i = 1; i<= length; i++){
            thisRow = new ArrayList<>();
            tempi = i;
            tempj = j;
            while(tempi <= j && tempj >= i){
                thisRow.add(a.get(tempi).get(tempj));
                tempi++;
                tempj--;
            }
            result.add(thisRow);
        }
        return result;
    }
}
