/**
 * @author pengsong
 * @date 18/1/2 上午10:02
 */
/*
Invert a binary tree.
 */
public class LC226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        return invertTree(root,root);
    }

    private TreeNode invertTree(TreeNode root, TreeNode node) {
        if(node==null)return root;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        invertTree(root,node.left);
        invertTree(root,node.right);
        return root;
    }
}
