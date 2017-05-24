/**
 * Created by ayushij on 1/16/17.
 */
public class ReverseAnInteger {
    public static void main(String args[]) {
        ReverseAnInteger obj = new ReverseAnInteger();
        System.out.println(obj.reverse(-1234567891));
    }
    public int reverse(int a) {
        long result = 0;
        while (Math.abs(a) > 0) {
            result = result * 10 + (a % 10);
            //System.out.println(result);
            a = a / 10;
        }
        if(result  > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            result = 0;
        return ((int)result);
    }

}
