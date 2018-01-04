/**
 * @author pengsong
 * @date 18/1/3 下午11:23
 */
/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
 */
/*
我的天啊，beats96.29%，我又一次写出这样的代码了。。。
 */
public class LC239SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0)return new int[0];
        int[] res=new int[nums.length-k+1];
        int j=0;
        res[j]=findMaxValue(nums,0,k);
        j++;
        for(int i=k;i<nums.length;i++){
            if(res[j-1]<=i-k)res[j]=findMaxValue(nums,i-k+1,i+1);
            else if(nums[res[j-1]]<nums[i])res[j]=i;
            else res[j]=res[j-1];
            j++;
        }
        for(int i=0;i<j;i++){
            res[i]=nums[res[i]];
            //System.out.print(res[i]+",");
        }
        return res;
    }

    private static int findMaxValue(int[] nums,int s, int e) {
        int maxIndex,maxValue;
        maxValue=nums[s];
        maxIndex=s;
        for(int i=s;i<e;i++){
            if(maxValue<nums[i]){
                maxIndex=i;
                maxValue=nums[i];
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
