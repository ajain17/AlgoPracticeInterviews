/**
 * Created by ayushij on 1/29/17.
 * You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

 X divides A i.e. A % X = 0
 X and B are co-prime i.e. gcd(X, B) = 1
 */
public class LargestCoprimeDivisor {
    public static  void main(String args[]){
        System.out.println(findCoprime(207,6));
    }

    public static int findCoprime(int a, int b) {
        while (gcd(a, b) != 1){

            System.out.println("a = " + a + " b = "+b +" gcd is "+ gcd(a, b));
            a = a / gcd(a, b);
            System.out.println("now a = " + a);

        }
        return a;
    }

    public static int gcd(int a, int b) {
        if(a%b==0)
            return b;
        else {
            return gcd(b,a%b);
        }
    }
}
