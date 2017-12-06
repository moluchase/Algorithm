/**
 * @author pengsong
 * @date 17/11/13 上午8:49
 */

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */

/*
参考：http://www.cnblogs.com/grandyang/p/4298435.html
其中用long是为了包含int的最大值
这道题的解法是对当前节点，都有一个min值和一个max值，
当前节点必须满足在min和max之间，才返回true，否则false，
最小值和最大值都由根节点和当前节点属于根节点的左还是右决定
 */
public class LC098ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minValue, long maxValue) {
        if(root==null)return true;
        if(root.val<=minValue||root.val>=maxValue)return false;
        return isValid(root.left,minValue,root.val)&&isValid(root.right,root.val,maxValue);
    }
}
