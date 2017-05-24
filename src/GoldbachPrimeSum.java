import java.util.ArrayList;

/**
 * Created by ayushij on 1/16/17.
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * If a < c OR a==c AND b < d.
 * update only if new element has first less than or equal to existing and second less that existing.
 */
public class GoldbachPrimeSum {
    public static void main(String args[]){
        GoldbachPrimeSum obj = new GoldbachPrimeSum();
        System.out.println(obj.isPrime(2));
        System.out.println(obj.primesum(4));
    }
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 2; i < a; i++) {
            if (isPrime(i) && isPrime(a - i)) {
                result.add(i);
                result.add(a - i);
                break;
            }
        }
        return result;
    }

    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
