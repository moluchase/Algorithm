/**
 * @author pengsong
 * @date 18/1/1 上午8:29
 */
/*
Given a complete binary tree, count the number of nodes.
写的真好,又是同一个人
https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958
 */
public class LC222CountCompleteTreeNodes {
    int height(TreeNode root){
        return root==null?-1:1+height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h=height(root);
        return h<0?0:height(root.right)==h-1?(1<<h)+countNodes(root.right):(1<<h-1)+countNodes(root.left);
    }

    public static void main(String[] args) {
        System.out.println(1<<4);
    }
}
