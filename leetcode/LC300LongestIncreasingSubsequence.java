import java.util.Arrays;

/**
 * @author pengsong
 * @date 18/1/8 上午10:00
 */
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
 */
/*
路径问题，dfs，虽然我知道dp可解，但是想不出来dp数组，没办法只能优化dfs
先是加了一个boolean数组，但是也只有21/24，然后加了一个int数组，就通过了
 */
public class LC300LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int count=0;
        boolean []flag=new boolean[nums.length];
        int[] curMax=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                flag[i]=true;
                count=Math.max(count,dfs(i,nums,nums[i],1,flag,curMax));
                //System.out.println("flag:"+i);
            }

        }
        return count;
    }

    private static int dfs(int i, int[] nums, int num,int out,boolean[]flag,int[]currMax) {
        if(i==nums.length-1){
            return out;
        }
        int temp=0;
        for(int j=i;j<nums.length;j++){
            if(nums[j]>num&&out>currMax[j]){
                flag[j]=true;
                currMax[j]=out;
                temp=Math.max(temp,dfs(j,nums,nums[j],out+1,flag,currMax));
            }
        }
        return Math.max(temp,out);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        /*
        int[]dp=new int[]{-1,1,2,3,5,6,7,8,9,10};
        int i= Arrays.binarySearch(dp,0,8,0);//原理就是左边的返回-1，右边的返回
        System.out.println(i);
        */
    }

    public int lengthOfLIS2(int[] nums)
    {
        // Base case
        if(nums.length <= 1)
            return nums.length;

        // This will be our array to track longest sequence length
        int T[] = new int[nums.length];

        // Fill each position with value 1 in the array
        for(int i=0; i < nums.length; i++)
            T[i] = 1;


        // Mark one pointer at i. For each i, start from j=0.
        for(int i=1; i < nums.length; i++)
        {
            for(int j=0; j < i; j++)
            {
                // It means next number contributes to increasing sequence.
                if(nums[j] < nums[i])
                {
                    // But increase the value only if it results in a larger value of the sequence than T[i]
                    // It is possible that T[i] already has larger value from some previous j'th iteration
                    if(T[j] + 1 > T[i])
                    {
                        T[i] = T[j] + 1;
                    }
                }
            }
        }

        // Find the maximum length from the array that we just generated
        int longest = 0;
        for(int i=0; i < T.length; i++)
            longest = Math.max(longest, T[i]);

        return longest;
    }

    /*
       public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

     */
}
