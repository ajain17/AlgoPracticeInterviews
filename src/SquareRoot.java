/**
 * Created by ayushij on 2/22/17.
 */
public class SquareRoot {
    public static void main(String args[]) {
        System.out.println(findRoot(2147483647));
    }
    private static int findRoot(int a){
        if(a == 0 || a == 1)
            return a;
       int lo = 1; int hi = a, ans=0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int x = mid*mid;
            if(x==a)
                return mid;
            if(x<a){
                ans = mid;
                lo = mid+1;
            } else{
                hi= mid-1;
            }
        }
        return ans;
    }
}

