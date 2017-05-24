/**
 * Created by ayushij on 12/22/16.
 * Find the substring count from a string without string functions in Java. Given String str = "abcdefghcde"; and String find = "cde";, count occurrences of "cde" in String str.
 Taking into account overlaps.

 Example: String str = "cdcdcdc"; and String find = "cdc";, occurrence count is 3
 */
public class SubstringCount {

    public static void main(String args[]) {
        String input = "cdcdcdcdcdcddc";
        String find = "cdc";
        StringBuffer found = new StringBuffer();
        int count = 0;
        int j;
        for ( int i = 0; i <input.length();){
            j = 0;
            while(j<find.length() && i<input.length() && input.charAt(i) == find.charAt(j)) {
                found.append(input.charAt(i));
                j++;
                i++;
            }
            i=i-j;
            if(found.toString().equals(find)) {
                count++;
            }
            i++;
            found.setLength(0);
        }
        System.out.println("count is " + count);
    }
}
