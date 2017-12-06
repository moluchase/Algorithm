import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pengsong
 * @date 17/11/14 上午8:58
 */

/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

/*
层次遍历，队列实现
 */
public class LC102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        List<List<Integer>>lists=new ArrayList<>();
        if(root==null)return lists;
        queue1.offer(root);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            List<Integer>list=new ArrayList<>();
            if(!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    TreeNode temp=queue1.poll();
                    list.add(temp.val);
                    if(temp.left!=null)queue2.offer(temp.left);
                    if(temp.right!=null)queue2.offer(temp.right);
                }
            }else {
                while (!queue2.isEmpty()){
                    TreeNode temp=queue2.poll();
                    list.add(temp.val);
                    if(temp.left!=null)queue1.offer(temp.left);
                    if(temp.right!=null)queue1.offer(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
