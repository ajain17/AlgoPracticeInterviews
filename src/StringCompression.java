/**
 * Created by ayushij on 1/7/17.
 * Compress a given string "aabbbccc" to "a2b3c3"
 constraint: inplace compression, no extra space to be used
 assumption : output size will not exceed input size.. ex input:"abb" -> "a1b2" buffer overflow.. such inputs will not be given.
 */
public class StringCompression {
    public static void main(String args[]){
        String input = "abcd";
        StringBuilder result = new StringBuilder();
        int count = 1;
        char current = input.charAt(0);
        result.append(current);
        for ( int i =1; i<input.length(); i++) {
            if(input.charAt(i) == current){
                count++;
            } else {
                if(count > 1)
                    result.append(count);
                current = input.charAt(i);
                result.append(input.charAt(i));
                count = 1;
            }
        }
        if(count>1)
            result.append(count);
        System.out.println(result.toString());
    }
}
