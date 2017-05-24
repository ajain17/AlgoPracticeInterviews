import java.util.Arrays;
import java.util.List;

/**
 * Created by ayushij on 12/20/16.
 */
public class GCD {
    public int gcd(int a, int b) {
        if(a%b==0)
           return b;
        else {
            return gcd(b,a%b);
        }
    }

    public static void main(String args[]){
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(1,0));
    }
}
