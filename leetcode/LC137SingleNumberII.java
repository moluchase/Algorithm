/**
 * @author pengsong
 * @date 17/12/7 上午8:53
 */
/*
Given an array of integers, every element appears three times except for one,
 which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity.
 Could you implement it without using extra memory?
 */
public class LC137SingleNumberII {
    public static int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int i=0;i<nums.length;i++){
            ones=(ones^nums[i])&~twos;
            twos=(twos^nums[i])&~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(~4));
    }
}
