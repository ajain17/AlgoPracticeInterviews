/**
 * Created by ayushij on 1/23/17.
 */
public class UnionMinusIntersection {

    public static void main(String args[]){

        UnionMinusIntersection obj = new UnionMinusIntersection();
        System.out.println(obj.func(2));
    }

    int func(int n){
        if(n==4)
            return 2;
        else
            return 2 * func(n+1);
    }


    /*ArrayList<Integer> getDistinctElements(Set a, Set b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i != a.size() && j != b.size()) {
            if (a.get(i) < b.get(j))
                result.add(a.get(i))
            i++;
	  else if (a.get(i) > b.get(j))
                result.add(b.get(j))
            j++;
	  else if (a.get(i) == b.get(j))
                i++;
            j++;
        }
        while (i < a.size())
            result.add(a.get(i))
        i++;
        while (j < b.size())
            result.add(b.get(j))
        j++;
        return result
    }*/
}
