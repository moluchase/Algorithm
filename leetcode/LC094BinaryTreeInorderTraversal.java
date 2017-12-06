import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/9 上午10:48
 */

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
 */

/*
给定一个二叉树，返回它的中序遍历的值
直接使用中序遍历的算法即可
 */
public class LC094BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorderTr(list,root);
        return list;
    }

    private void inorderTr(List<Integer> list, TreeNode root) {
        if(root!=null){
            inorderTr(list,root.left);
            list.add(root.val);
            inorderTr(list,root.right);
        }
    }
}
