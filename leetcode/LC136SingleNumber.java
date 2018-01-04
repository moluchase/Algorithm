/**
 * @author pengsong
 * @date 17/12/7 上午8:49
 */

/*
Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class LC136SingleNumber {
    public int singleNumber(int[] nums) {
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp^=nums[i];
        }
        return temp;
    }
}
