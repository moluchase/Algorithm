/**
 * @author pengsong
 * @date 17/12/12 上午8:58
 */
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
/*
参考：https://discuss.leetcode.com/topic/3581/share-my-dp-code-that-got-ac
 */
public class LC152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int preg,pref,res;
        res=preg=pref=nums[0];
        for(int i=1;i<nums.length;i++){
            int g=Math.max(Math.max(pref*nums[i],preg*nums[i]),nums[i]);
            int f=Math.min(Math.min(pref*nums[i],preg*nums[i]),nums[i]);
            res=Math.max(res,g);
            pref=f;
            preg=g;
        }
        return res;
    }

    /*
    参考：https://discuss.leetcode.com/topic/4417/possibly-simplest-solution-with-o-n-time-complexity/43?page=3
        public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;}
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
     */
}
