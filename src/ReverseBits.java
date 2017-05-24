/**
 * Created by ayushij on 1/2/17.
 */
public class ReverseBits {
    public static void main(String args[]) {
        ReverseBits reverseBits = new ReverseBits();
        long n = 31;
        //System.out.println(reverseBits.rev(n));
        System.out.println(Integer.toBinaryString(101&1));
        System.out.println(reverseBits.reverseBits(5));
    };

    public long rev(long n){
        System.out.println(Long.toBinaryString(n));
        StringBuilder x = new StringBuilder(Long.toBinaryString(n));
        while(x.length()!=32){
            x.insert(0,'0');
        }
        StringBuilder result = new StringBuilder();

        for(int i = 0; i<32; i++){
            result.insert(i,x.charAt(31-i));

        }
        long res = Long.parseLong(result.toString(),2);
        return res;
    }

    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        System.out.println(Integer.toBinaryString(a)+ "  " + Integer.toBinaryString(b));
        if ((a ^ b) != 0) {
            System.out.println(Integer.toBinaryString((1 << i) | (1 << j)));
            System.out.println(Integer.toBinaryString(n^(1 << i) | (1 << j)));
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }
}
