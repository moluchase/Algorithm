/**
 * @author pengsong
 * @date 17/11/13 上午9:45
 */

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?
 */

/*
首先知道二叉搜索树的原理，如果用中序遍历，则遍历后的结果是有序的，那么如果交换两个节点，遍历后的结果就不是有序的
有一种解法是：用一个数组存储遍历后的结果，排序好后再将其赋值给二叉树
但是上面的解法空间复杂度为O(n)

对于一个有序数组，交换两个元素，如下
2,3,7,9,11,34,45
2,34,7,9,11,3,45
会发现存在两次前一个节点大于后一个节点的情况，而这两次恰恰对应两个交换的节点
这样我们用三个指针就可以完成了，一个是第一个要交换的节点，一个是第二个要交换的节点，另外一个是前向节点
用中序遍历的思想

参考：https://discuss.leetcode.com/topic/3988/no-fancy-algorithm-just-simple-and-powerful-in-order-traversal
 */
public class LC099RecoverBinarySearchTree {

    TreeNode firstNode=null;
    TreeNode secondNode=null;
    TreeNode preNode=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        transfor(root);

        int temp=firstNode.val;
        firstNode.val=secondNode.val;
        secondNode.val=temp;
    }

    private void transfor(TreeNode root) {
        if(root==null)return;
        transfor(root.left);
        if(firstNode==null&&(preNode.val>=root.val))firstNode=preNode;
        if(firstNode!=null&&preNode.val>=root.val)secondNode=root;
        preNode=root;
        transfor(root.right);
    }

    /*
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {

        inOrderTraversal(root);

        if (firstElement != null && secondElement != null) {
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }
    }

    private void inOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);

        if (firstElement == null && (prev == null || prev.val >= root.val)) {
            firstElement = prev;
        }

        if (firstElement != null && prev.val >= root.val) {
            secondElement = root;
        }

        prev = root;

        inOrderTraversal(root.right);
    }
     */
}
