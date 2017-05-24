import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ayushij on 12/22/16.
 */
public class plusOne {
    public static int[] plusOne(int[] digits) {
        return increment(digits, digits.length - 1);
    }

    private static int[] increment(int[] digits, int index) {
        if (digits[index] != 9) {
            digits[index] += 1;
            return digits;
        } else {
            digits[index] = 0;
            if (index > 0) {
                return increment(digits, index - 1);
            } else {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                return newDigits;
            }
        }
    }

    public ArrayList<Integer> plusOneIterative(int[] digits) {
        ArrayList<Integer> result = new ArrayList();
        //digits = pruneArray(digits);
        int i = digits.length-1;
        int carry = 0;
        while (i >= 0) {
            if(digits[i] < 9) {
                digits[i]++;
                carry = 0;
                break;
            } else {
                digits[i] = 0;
                carry = 1;
            }
            i--;
        }
        if ( carry == 1 ) {
            result.add(0,1);
        }
        for ( int x : digits)
            result.add(x);
        return result;
    }

    int[] pruneArray(int[] digits) {
        int i = 0;
        for(; i < digits.length; i++) {
            if (digits[i] != 0) {
                break;
            }
        }
        digits = Arrays.copyOfRange(digits, i, digits.length);
        return digits;
    }

    public static void main(String args[]) {
        int[] arr = {8,9};
        //System.out.println(Arrays.toString(plusOne(arr)));
        plusOne obj = new plusOne();
        int[] digits = {0};
        System.out.println(obj.plusOneIterative(digits));
    }
}