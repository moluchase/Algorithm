import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pengsong
 * @date 17/11/14 上午9:36
 */

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

/*
层次遍历，栈实现,这是我在刷剑指offer时做的
下面有一种解法是在leetcode上看到的，确实很经典，而且省去了两个stack的空间
 */

public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> reStack=new Stack<>();
        Stack<TreeNode> stack=new Stack<>();
        List<List<Integer>>lists=new ArrayList<>();
        if(root==null)return lists;
        reStack.push(root);
        while (!reStack.isEmpty()||!stack.isEmpty()){
            List<Integer>list=new ArrayList<>();
            if(!reStack.isEmpty()){
                while (!reStack.isEmpty()){
                    TreeNode temp=reStack.pop();
                    list.add(temp.val);
                    if(temp.left!=null)stack.push(temp.left);
                    if(temp.right!=null)stack.push(temp.right);
                }
            }else {
                while (!stack.isEmpty()){
                    TreeNode temp=stack.pop();
                    list.add(temp.val);
                    if(temp.right!=null)reStack.push(temp.right);
                    if(temp.left!=null)reStack.push(temp.left);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode node, int level, List<List<Integer>> res){
        if(node == null) return;

        if(res.size() <= level)
                res.add(level, new LinkedList<Integer>());

        if(level%2 == 0)    res.get(level).add(node.val);
        else                res.get(level).add(0,node.val);

        helper(node.left, level+1, res);
        helper(node.right, level+1, res);
    }
     */
}
