/**
 * @author pengsong
 * @date 17/12/12 上午10:04
 */
/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 */
/*
参考：https://discuss.leetcode.com/topic/6468/my-pretty-simple-code-to-solve-it/3
这种题做个模板吧
有个问题我觉得很好：
a simple question: why mid = lo + (hi - lo) / 2 rather than mid = (hi + lo) / 2 ?
This is a famous bug in binary search.
if the size of array are too large, equal or larger than the upper bound of int type,
hi + lo may cause an overflow and become a negative number.
It's ok to write (hi + lo) / 2 here, leetcode will not give you a very large array to test. But we'd better know this.
For a detailed information or history of this bug, you could search "binary search bug" on google.
 */
public class LC154FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        int start,mid,end;
        start=0;
        end=nums.length-1;
        mid=0;
        while (start<end){
            mid=(start+end)/2;
            if(nums[mid]<nums[end])end=mid;
            else if(nums[mid]>nums[end])start=mid+1;
            else end--;
        }
        return nums[start];
    }
}
