/**
 * @author pengsong
 * @date 18/1/6 上午8:36
 */
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class LC283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++)if(nums[i]!=0)nums[k++]=nums[i];
        for(int i=k;i<nums.length;i++)nums[i]=0;
    }
}
