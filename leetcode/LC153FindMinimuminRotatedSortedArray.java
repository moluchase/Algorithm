/**
 * @author pengsong
 * @date 17/12/12 上午9:34
 */

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 */
/*
二分查找
很费劲
 */
public class LC153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)return -1;
        if(nums.length==1)return nums[0];
        int start,middle,end;
        int res;
        start=0;
        end=nums.length-1;
        middle=(start+end)/2;
        res=Integer.MAX_VALUE;
        while (start<=end){
            if(nums[middle]>nums[start]||middle==start){
                res=Math.min(res,nums[start]);
                start=middle+1;
                middle=(start+end)/2;
            }else{
                res=Math.min(res,nums[middle]);
                end=middle-1;
                middle=(start+end)/2;
            }
        }
        return res;
    }
}
