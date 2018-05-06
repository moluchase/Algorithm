/**
 * @author pengsong
 * @date 18/1/12 上午10:32
 */

/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

/*
参考：https://leetcode.com/problems/burst-balloons/discuss/76228
 */
public class LC312BurstBalloons {
    public int maxCoins(int[] nums) {
        int n=1;
        int[] arr=new int[nums.length+2];
        for(int i=0;i<nums.length;i++)if(nums[i]!=0)arr[n++]=nums[i];
        arr[0]=arr[n++]=1;
        int[][]memo=new int[n][n];
        return helper(memo,arr,0,n-1);
    }

    private int helper(int[][] memo, int[] arr, int left, int right) {
        if(left+1==right)return 0;
        if(memo[left][right]!=0)return memo[left][right];
        int res=0;
        for(int i=left+1;i<right;i++){
            res=Math.max(res,arr[left]*arr[i]*arr[right]+helper(memo,arr,left,i)+helper(memo,arr,i,right));
        }
        memo[left][right]=res;
        return res;
    }
}
