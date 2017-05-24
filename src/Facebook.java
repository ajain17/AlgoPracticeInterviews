import java.util.*;

/**
 * Created by ayushij on 2/22/17.
 */
public class Facebook {
    public static void main(String args[]){
        Facebook facebook = new Facebook();
        //facebook.generateBinaryNumbers(5);
        //int[] arr = {1,0,3,0,0,4,5};
        int[] arr = {1,2,4,5,6,7};
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++){

            int randomIndex = rand.nextInt(i+1);
            System.out.println("generating between 0 and " + i + " " + randomIndex);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        int [] original = arr;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(original));

        //facebook.moveZeros(arr);
        /*System.out.println(facebook.strStr("aabaaaababaa" +
                "bbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb","bba"));*/
        /*ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(0);
        a.add(1);
        //facebook.threesum(a,1);
        //System.out.println(facebook.threeSum(a));
        System.out.println(facebook.power(3,5));*/
        //System.out.println(facebook.findPivot(arr,0,arr.length-1));
    }

    private int findPivot(int[] arr, int lo, int hi){
        System.out.println(lo+ " ," + (lo+hi)/2 + " ," + hi);
        if(hi<lo)
            return -1;
        int mid = (lo+hi)/2;

        if(mid>lo && arr[mid]<arr[mid-1])
            return mid-1;
        if(mid<hi && arr[mid]>arr[mid+1])
            return mid;
        if(arr[lo]<arr[mid])
            return findPivot(arr,mid+1,hi);
            return findPivot(arr,lo,mid-1);
    }

    private int power(int x, int y){
        int temp;
        System.out.println(x + " ^ " + y);
        if(y==0){
            return 1;
        }
        if(y==1)
            return x;
        if(y%2==1){
            temp = x*power(x,y/2)*power(x,y/2);
            System.out.println("temp odd is " + temp);
        }
        else{
            temp = power(x,y/2)*power(x,y/2);
            System.out.println("temp even is " + temp);
        }
        System.out.println("returning temp" + temp);
        return temp;
    }
    private void generateBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        if (n == 1){
            System.out.println(q.poll());
            return;
        }
        StringBuilder element = new StringBuilder();
        while(n-- > 0){
            element.append(q.poll());
            System.out.println(element);
            q.add(element+"0");
            q.add(element+"1");
            element.setLength(0);
        }
    }

    private void moveZeros(int[] arr){
        int i = arr.length -1;
        int j = i;
        for(i=arr.length-1;i>=0;i--,j--){
            if(arr[j]==0) {
                while (arr[j] != 0)
                    --j;
                arr[i] = arr[j];
                arr[j] = 0;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        if (A == null)
            return res;

        Collections.sort(A);

        System.out.println(A);
        System.out.println(A.get(A.size()-1));
        int n = A.size();

        for (int low = 0; low < n - 2; low++) {

            int mid = low + 1;
            int high = n - 1;
            int sum = -A.get(low);

            if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue()){
                System.out.println("need to continue at " + low);
                continue;

            }


            while (mid < high) {

                int num = A.get(mid) + A.get(high);

                if (num == sum) {
                    temp.add(A.get(low));
                    temp.add(A.get(mid));
                    temp.add(A.get(high));
                    res.add(new ArrayList(temp));
                    temp.clear();

                    int prev = mid;
                    while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
                        mid++;

                } else if (num < sum) {
                    mid++;
                } else {
                    high--;
                }
            }
        }

        return res;


    }

    private void threesum(ArrayList<Integer> a, int b){
        Collections.sort(a);
        System.out.println(a);
        int closest = Integer.MAX_VALUE;
        int x,y,z;
        for(int i = 0; i<a.size(); i++){

        }
    }

    private int strStr(final String haystack, final String needle) {
        int j = 0;
        for(int i = 0; i<haystack.length();i++){
            System.out.println("character at " + i + " is " + haystack.charAt(i));
            if(haystack.charAt(i)==needle.charAt(j)){
                System.out.println("j is " + j);
                if(j==needle.length()-1){
                    System.out.println("found match");
                    return (i - needle.length() +1);
                }

                else
                    j++;
            }
            else {
                System.out.println("resetting j at " + i + " i will be " + (i-j));
                i = i - j;
                j=0;

            }
        }
        return -1;
    }
}
