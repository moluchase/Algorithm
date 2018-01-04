/**
 * @author pengsong
 * @date 17/12/7 上午9:42
 */
/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */

/*
这道题在刷牛客网时，见到过，主要就是如何区分这两个数
 */
public class LC260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int temp=0;
        int index;
        int []res=new int[2];
        for(int i=0;i<nums.length;i++){
            temp^=nums[i];
        }
        String s=Integer.toBinaryString(temp);
        index=s.length()-1;
        while(index>=0&&s.charAt(index)=='0')index--;
        index=s.length()-index;
        for(int i=0;i<nums.length;i++){
            s=Integer.toBinaryString(nums[i]);
            if(index>s.length()||s.charAt(s.length()-index)=='0')res[0]^=nums[i];
            else res[1]^=nums[i];
        }
        return res;
    }
}
