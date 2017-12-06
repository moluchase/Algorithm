/**
 * @author pengsong
 * @date 17/11/17 上午9:22
 */

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree,
 each node's right child points to the next node of a pre-order traversal.
 */

/*
这道题的意思就是说将左节点连到父节点的右节点，原右节点连到新右节点的右节点
调了半个小时，写好了，其实很简单
 */
public class LC114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(null,root);
    }

    private void flatten(TreeNode parent, TreeNode child) {
        if(parent!=null&&child.left==null)return;
        while (child!=null){
            if(child.left!=null){
                flatten(child,child.left);
                TreeNode temp=child.right;
                child.right=child.left;
                child.left=null;
                TreeNode temp2=child;
                while (temp2.right!=null)temp2=temp2.right;
                temp2.right=temp;
            }
            child=child.right;
        }
    }
}

/*
//真简单
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode temp = root.left;
        while (temp != null && temp.right != null) {
            temp = temp.right;
        }

        flatten(root.right);
        if (temp != null) {
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
 */
