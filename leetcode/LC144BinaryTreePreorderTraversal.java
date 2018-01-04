import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pengsong
 * @date 17/12/10 上午8:37
 */
/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
/*
前序遍历的非递归形式
 */
public class LC144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null)stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);
        }
        return list;
    }
    public void preorderTraversal(List<Integer> list,TreeNode node) {
        if(node!=null){
            list.add(node.val);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    public void orderTraversal(List<Integer> list,TreeNode node) {
        if(node!=null){
            orderTraversal(node.left);
            list.add(node.val);
            orderTraversal(node.right);
        }
    }
    public List<Integer> orderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null)stack.push(root);
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                list.add(node.val);
                node=node.right;
            }
        }
        return list;
    }

}
