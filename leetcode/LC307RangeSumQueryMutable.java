/**
 * @author pengsong
 * @date 18/1/10 下午10:55
 */
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */
/*
哎，超时了。。。
下面是参看discuss上排第一的写的
这样的题目需要记录一下。。。
 */
public class LC307RangeSumQueryMutable {
    int[] nums2, nums;

    public LC307RangeSumQueryMutable(int[] nums) {
        nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) nums2[i] = nums[i];
            else nums2[i] = nums[i] + nums2[i - 1];
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        int temp = val - nums[i];
        nums[i] = val;
        for (int j = i; j < nums.length; j++) nums2[j] += temp;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return nums2[j];
        else return nums2[j] - nums2[i - 1];
    }
}

class NumArray {
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int s, int e) {
        if (s > e) return null;
        SegmentTreeNode ret = new SegmentTreeNode(s, e);
        if (s == e) {
            ret.sum = nums[s];
            return ret;
        }
        int mid = s + (e - s) / 2;
        ret.left = buildTree(nums, s, mid);
        ret.right = buildTree(nums, mid + 1, e);
        ret.sum = ret.left.sum + ret.right.sum;
        return ret;
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid < pos) update(root.right, pos, val);
        else update(root.left, pos, val);
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if (mid < i) return sumRange(root.right, i, j);
        else if (mid >= j) return sumRange(root.left, i, j);
        else return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
    }
}