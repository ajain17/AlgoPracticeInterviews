/**
 * Created by ayushij on 12/28/16.
 */
public class InterleavingStrings {
    public static void main(String args[]) {
        InterleavingStrings obj = new InterleavingStrings();
        String a = "USfMSU";
        String b = "5YgZ9N5mR6ppfggzbzh7HTox85MwFtaIQDHfzJW8vc2G";
        String c = "5YgUSZf9NM5SmR6Uppfggzbzh7HTox84MwFtaIQDHfzJW8vc2G";
        System.out.println(obj.isInterleave(a,b,c));
    }
    public int isInterleave(String a, String b, String c) {
        int countA = 0;
        int countB = 0;
        if(c.length() != (a.length()+b.length()))
            return 0;

        for(int i = 0;i<c.length();){
            if(c.charAt(i) == a.charAt(countA) && countA < a.length()-1){
                countA++;
                i++;
                System.out.println("checked a till" + countA);
            }
            if(c.charAt(i) == b.charAt(countB) && countB<b.length()-1){
                countB++;
                i++;
                System.out.println("checked b till" + countB);
            }
        }

        if(countA== a.length() && countB == b.length())
            return 1;
        return 0;
    }
}
