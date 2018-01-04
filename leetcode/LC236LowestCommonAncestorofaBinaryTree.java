/**
 * @author pengsong
 * @date 18/1/3 上午10:37
 */
/*
前面一道是二叉搜索树，这个一般化
膜拜这两道题的解法
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225
 */
public class LC236LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
