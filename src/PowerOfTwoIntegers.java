/**
 * Created by ayushij on 1/16/17.
 * Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

 Example

 Input : 4
 Output : True
 as 2^2 = 4.
 */
public class PowerOfTwoIntegers {
    public static void main(String args[]){
        PowerOfTwoIntegers obj = new PowerOfTwoIntegers();
        System.out.println(obj.isPower(102400));
    }

    public boolean isPower(int n) {
        if(n == 1)
            return true;
        int lastNum = 2;
        for(int i = 2; i <= 32 && lastNum <= Math.sqrt(n); i++ ){
            System.out.println("checking for lastnum " + lastNum + " power " + i );
            if((Math.pow(lastNum,i)) == n)
                return true;
            if((Math.pow(lastNum,i)) > n){
                lastNum++;
                i=1;
            }
        }
        return false;
    }

}
