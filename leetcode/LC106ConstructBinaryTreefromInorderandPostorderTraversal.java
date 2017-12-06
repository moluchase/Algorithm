/**
 * @author pengsong
 * @date 17/11/15 下午9:04
 */

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

/*
这道题和上道题类型一样，这次就不用ArrayList了，直接用下标解决
主要的问题在于start，end对应的是inorder，index对应的是postorder
 */
public class LC106ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0,inorder.length-1,postorder.length-1,inorder,postorder);
    }

    private TreeNode buildTree(int start, int end, int index, int[] inorder, int[] postorder) {
        if(start>end)return null;
        TreeNode node=new TreeNode(postorder[index]);
        int k=start;
        while (inorder[k]!=postorder[index])k++;
        node.left=buildTree(start,k-1,index-(end-k)-1,inorder,postorder);
        node.right=buildTree(k+1,end,index-1,inorder,postorder);
        return node;
    }
}
