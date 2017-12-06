/**
 * @author pengsong
 * @date 17/11/20 上午8:56
 */

/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
/*
写了大半个小时，先开始想用层次遍历，看了看之前的代码，虽然可以不用开辟空间，但是始终是dfs，不能一行一行的遍历
无奈，只能手写一个while循环来实现，结果还和leetcode上的一模一样
 */
public class LC116PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null||root.left==null)return;
        TreeLinkNode par=root;
        root.next=null;
        while (par.left!=null){
            TreeLinkNode p=par;
            while (p!=null){
                p.left.next=p.right;
                if(p.next!=null)p.right.next=p.next.left;
                else p.right.next=null;
                p=p.next;
            }
            par=par.left;
        }
    }
/*
    private void connect(TreeLinkNode node, TreeLinkNode parent) {
        if(node!=null){
            if(node.left!=null)node.left.next=node.right;
            if(node.right!=null){
                if(parent.next!=null)node.right.next=parent.next.left;
                else node.right.next=null;
            }
            connect(node.left,node);
            connect(node.right,node);
        }
    }
*/
}
