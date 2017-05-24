import java.util.Arrays;

/**
 * Created by ayushij on 1/28/17.
 */
public class NoOfTrailingZeros {
    public static void main(String [] args){
        NoOfTrailingZeros obj = new NoOfTrailingZeros();
        System.out.println(obj.trailingZeroes(5));

    }
    public int trailingZeroes(int n) {

        int count = 0;
        while(n>=5){
            count++;
            n = n/2;
        }
        return count;
    }

    private long factorial(int a){
        if ( a == 0)
            return 0;
        long fact=1;
        int i = 1;
        while(a>0){
            fact *= a--;
            System.out.println(i++ +": "+ fact);
        }
        return fact;
    }
}
