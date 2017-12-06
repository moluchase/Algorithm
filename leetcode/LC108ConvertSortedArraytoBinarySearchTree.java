/**
 * @author pengsong
 * @date 17/11/16 上午8:41
 */

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/*
给一个数组，生成一个平衡二叉搜索树
这道题非常简单，可以看成二分，时间复杂度是O(n)
 */
public class LC108ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(0,nums.length-1,nums);
    }

    private TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        if(start>end)return null;
        int middle=(start+end)/2;
        TreeNode node=new TreeNode(nums[middle]);
        node.left=sortedArrayToBST(start,middle-1,nums);
        node.right=sortedArrayToBST(middle+1,end,nums);
        return node;
    }
}
