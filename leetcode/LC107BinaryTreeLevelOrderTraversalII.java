import java.util.LinkedList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/15 下午10:19
 */

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

/*
这道题和之前的层次遍历的题目一样，就是生成的列表一个是正序，一个是倒序

这里要注意的是LinkedList<List<Integer>> lists=new LinkedList<>();这行语句
写成List<List<Integer>> lists=new LinkedList<>();不能调用addFirst方法
写成这样LinkedList<List<Integer>> lists=new LinkedList<>();不能正确返回
 */
public class LC107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> lists=new LinkedList<>();
        addLevel(lists,0,root);
        return lists;
    }

    private void addLevel(LinkedList<List<Integer>> lists, int i, TreeNode root) {
        if(root==null)return;
        if(i>=lists.size())lists.addFirst(new LinkedList<Integer>());
        lists.get(lists.size()-i-1).add(root.val);
        addLevel(lists,i+1,root.left);
        addLevel(lists,i+1,root.right);
    }
}
