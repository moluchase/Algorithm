/**
 * @author pengsong
 * @date 17/12/13 上午8:41
 */
/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */
public class LC162FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        if(nums.length==1)return 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){if(nums[i]>nums[i+1])return i;}
            else if(i==nums.length-1){if(nums[i]>nums[i-1])return i;}
            else {
                System.out.println(nums[i-1]+","+nums[i]+","+nums[i+1]);
                if((nums[i]>nums[i-1])&&(nums[i]>nums[i+1]))return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }
}
