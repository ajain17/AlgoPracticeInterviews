/**
 * Created by ayushij on 1/8/17.
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once
 */
public class FindDuplicateNumber {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,2};
        FindDuplicateNumber obj = new FindDuplicateNumber();
        System.out.println(obj.findDuplicate3(arr));
    }

    int findDuplicate3(int[] nums)
    {
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            System.out.println("slow is " + slow + " fast is " + fast);
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
                System.out.println("slow is " + slow + " fast is " + fast);
            }
            System.out.println("******");
            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
                System.out.println("slow is " + slow + " fast is " + fast);
            }
            return slow;
        }
        return -1;
    }
}
