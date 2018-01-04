/**
 * @author pengsong
 * @date 17/12/25 上午8:54
 */
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */
/*
随便想到的一个，然后超时了，但是下面这个最高赞的答案可是和我的一模一样啊，怎么就通过了呢，还最高赞...
 */
public class LC209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int i,j,sum;
        int res=Integer.MAX_VALUE;
        sum=i=j=0;
        while (j<nums.length){
            sum+=nums[j];
            if(sum>=s){
                while (sum-nums[i]>=s){
                    sum-=nums[i];
                    i++;
                }
                res=Math.min(res,j-i+1);
            }
            j++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int i,j,sum;
        int res=Integer.MAX_VALUE;
        sum=i=j=0;
        while (j<nums.length){
            sum+=nums[j++];
            while (sum>=s){
                res=Math.min(res,j-i);
                sum-=nums[i++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
