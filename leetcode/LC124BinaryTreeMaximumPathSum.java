/**
 * @author pengsong
 * @date 17/11/24 上午8:38
 */

/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

/*
下面这种方法很清楚了
https://discuss.leetcode.com/topic/4407/accepted-short-solution-in-java/41?page=3
discuss中说避免全局变量，像这种解法避免全局变量也只能通过数组了
 */
public class LC124BinaryTreeMaximumPathSum {
    int maxValue;
    public int maxPathSum(TreeNode root) {
       maxValue=Integer.MIN_VALUE;
       dfsMax(root);
       return maxValue;
    }

    private int dfsMax(TreeNode root) {
        if(root==null)return 0;
        int left=Math.max(0,dfsMax(root.left));
        int right=Math.max(0,dfsMax(root.right));
        maxValue=Math.max(maxValue,left+right+root.val);
        return Math.max(left,right)+root.val;
    }


/*
    private int dfsSub(TreeNode root,int i,int maxValue){
        if(root==null)return maxValue;
        i=i+root.val;
        if(i>maxValue)maxValue=i;
        maxValue=dfsSub(root.left,i,maxValue);
        maxValue=dfsSub(root.right,i,maxValue);
        return maxValue;
    }

    private int dfsMax(TreeNode root, int i,int maxValue) {
        if(root==null)return maxValue;
        int leftValue=dfsSub(root.left,i,0);
        int rightValue=dfsSub(root.right,i,0);
        maxValue=Math.max(maxValue,root.val+leftValue+rightValue);
        leftValue=Math.max(root.val+leftValue,leftValue);
        rightValue=Math.max(root.val+rightValue,rightValue);
        maxValue=Math.max(maxValue,rightValue);
        maxValue=Math.max(maxValue,leftValue);
        maxValue=dfsMax(root.left,0,maxValue);
        maxValue=dfsMax(root.right,0,maxValue);
        return maxValue;
    }
    */
}
