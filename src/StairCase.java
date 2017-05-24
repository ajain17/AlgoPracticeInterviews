import java.util.ArrayList;

/**
 * Created by ayushij on 12/31/16.
 *
 * A child is running up a staircase with n steps
 * no of hops = 1 2
 */
public class StairCase {
    static long[] result = new long[1000];
    public static void main(String args[]) {
        StairCase stairCase = new StairCase();
        int n = 3;
        //int [] result;
        System.out.println(stairCase.countHops3(n));
    }
    public int countHops2(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return countHops2(n-1) + countHops2(n-2);
    }

    public long countHops3(int n) {
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;

        if(n<3)
            return result[n];
        else{
            for(int i = 3; i<=n; i++){
                result[i] = result[i-1]+result[i-2] + result[i-3];
            }
        }
        return result[n];
    }
    }
