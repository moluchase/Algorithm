/**
 * @author pengsong
 * @date 18/1/24 上午10:28
 */
/*
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
/*明天再做，和前面做到的题一样。。。
题意可以转换为对每个元素（这里过滤一下：选取大于lower的元素），找出它后面小于upper的元素，
呜呜，不想做额
 */
public class LC327CountofRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        mergesort(nums,0,nums.length-1,lower,upper);
        return 0;
    }

    private void mergesort(int[] nums, int s, int e, int lower, int upper) {
    }
}
