/**
 * @author pengsong
 * @date 17/11/14 上午8:41
 */

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */

/*
这种题目比较死板，直接递归可解
 */
public class LC101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSym(root.left,root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right) {
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        return left.val==right.val&&isSym(left.left,right.right)&&isSym(left.right,right.left);
    }
}
