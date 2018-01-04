import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pengsong
 * @date 17/12/10 上午8:50
 */
/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class LC145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> isTraversal=new ArrayList<>();
        TreeNode node=root;
        if(root!=null)stack.push(root);
        isTraversal.add(null);//目的是为了下面的if语句中的判断，如果只有一个孩子的情况
        while (!stack.isEmpty()){
            node=stack.peek();
            if((node.left==null&&node.right==null)||(isTraversal.contains(node.left)&&isTraversal.contains(node.right))){
                list.add(node.val);
                stack.pop();
            }else{
                if(node.right!=null){
                    stack.push(node.right);
                    isTraversal.add(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                    isTraversal.add(node.left);
                }
            }
        }
        return list;
    }
    public void postorderTraversal(List<Integer> list,TreeNode node) {
        if(node!=null){
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            list.add(node.val);
        }
    }
}
