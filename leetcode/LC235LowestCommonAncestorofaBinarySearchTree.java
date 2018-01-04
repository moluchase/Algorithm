import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 18/1/3 上午9:51
 */
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 */
/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963
这道题针对的是二叉搜索树，那么对一般的树呢？
 */
public class LC235LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
