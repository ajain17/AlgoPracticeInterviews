import java.util.HashSet;

/**
 * Created by ayushij on 12/22/16.
 */

public class LongestSubstringNonRepeatedChars {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;

        HashSet<Character> set = new HashSet<Character>();

        int max=0;

        int i=0;
        int start=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
            }else{
                max = Math.max(max, set.size());

                while(start<i&&s.charAt(start)!=c){
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }

            i++;
        }

        max = Math.max(max, set.size());

        return max;
    }

}