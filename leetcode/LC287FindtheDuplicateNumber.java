/**
 * @author pengsong
 * @date 18/1/6 上午9:53
 */
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
/*
很经典的题目，尤其是使用快慢指针
 */
public class LC287FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length<=1)return -1;
        int slow,fast;
        slow=nums[0];
        fast=nums[slow];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while (fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return slow;
    }

    public static int findDuplicate2(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums.length) {
                if (nums[nums[i] - nums.length] > nums.length) return nums[i] - nums.length;
                nums[nums[i]-nums.length]+=nums.length;
            }else {
                if(nums[nums[i]]>nums.length)return nums[i];
                else nums[nums[i]]+=nums.length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate2(new int[]{1,2,3,4,2,5}));
    }
}
