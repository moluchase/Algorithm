/**
 * @author pengsong
 * @date 17/11/16 下午6:26
 */

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
/*
这个是最常规的解法，在牛客网上用到过
 */
public class LC110BalancedBinaryTree {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        treeDepth(root);
        return flag;
    }

    private int treeDepth(TreeNode node) {
        if(node==null)return 0;
        int lenl,lenr;
        lenl=treeDepth(node.left)+1;
        lenr=treeDepth(node.right)+1;
        if(Math.abs(lenl-lenr)>1)flag=false;
        return lenl>lenr?lenl:lenr;
    }
}

/*
下面这种方法可以取消全局变量
class solution {
public:
int dfsHeight (TreeNode *root) {
        if (root == NULL) return 0;

        int leftHeight = dfsHeight (root -> left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root -> right);
        if (rightHeight == -1) return -1;

        if (abs(leftHeight - rightHeight) > 1)  return -1;
        return max (leftHeight, rightHeight) + 1;
    }
    bool isBalanced(TreeNode *root) {
        return dfsHeight (root) != -1;
    }
};
 */
