import java.util.Arrays;

/**
 * @author pengsong
 * @date 18/1/23 上午11:28
 */
/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
/*
这道题也太规则了吧，虽然没有按照follow up上的做，
但是下面这个在discuss上看到的也不错额，我是用java实现的，看起来也太简单了
https://discuss.leetcode.com/topic/32861/3-lines-python-with-explanation-proof
又是这个人，不过这个家伙要是不是leetcode的员工的话，也太厉害了吧
 */
public class LC324WiggleSortII {
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[]nums2=new int[nums.length];
        for(int i=0;i<nums.length;i++)nums2[i]=nums[i];
        for(int i=nums.length%2==0?nums.length/2-1:nums.length/2,k=0,j=nums.length-1;i>=0;i--,j--){
            nums[k++]=nums2[i];
            if((nums.length%2==0&&i>=0)||(nums.length%2!=0&&i>0))nums[k++]=nums2[j];
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{1,5,1,1,6,4});
    }
}
