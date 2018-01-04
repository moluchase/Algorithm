/**
 * @author pengsong
 * @date 17/12/20 上午9:47
 */
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
/*
搞不懂这种题目为什么是easy，可能是我现在的状态不好吧
dp问题
 */
public class LC198HouseRobber {
    public int rob(int[] nums) {
        int n=nums.length;
        int [][]dp=new int[2][n+1];
        for(int i=1;i<=n;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i]=dp[0][i-1]+nums[i-1];
        }
        return Math.max(dp[0][n],dp[1][n]);
    }
}
