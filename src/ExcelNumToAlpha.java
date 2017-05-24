import java.util.Arrays;

/**
 * Created by ayushij on 1/5/17.
 * Find Excel column name from a given column number

 Input          Output
 26             Z
 51             AY
 52             AZ
 80             CB
 676            YZ
 702            ZZ
 705            AAC
 */
public class ExcelNumToAlpha {

    public static void main(String args[]) {
        ExcelNumToAlpha obj = new ExcelNumToAlpha();
        obj.numtoalpha(943566);
        obj.alphatonum("AAC");
    }

    void numtoalpha(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            result.append((char)((n-1)%26 + 'A'));
            n = (n-1)/26;
        }
        System.out.println(result.reverse().toString());
    }

    void alphatonum(String input) {
        int result=0;
        for(int i =0 ;i<input.length();i++){
            result = result*26 + ((input.charAt(i)-'A')+1);
        }
        System.out.println(result);
    }
}
