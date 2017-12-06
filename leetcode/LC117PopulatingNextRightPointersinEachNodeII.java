/**
 * @author pengsong
 * @date 17/11/20 上午10:08
 */

/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
/*
下面这个解法是看leetcode上的discuss上解决的
参考：https://discuss.leetcode.com/topic/8447/simple-solution-using-constant-space/8
 */
public class LC117PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode temp=new TreeLinkNode(0);
        while (root!=null){
            TreeLinkNode curr=temp;
            while (root!=null){
                if(root.left!=null){
                    curr.next=root.left;
                    curr=curr.next;
                }
                if(root.right!=null){
                    curr.next=root.right;
                    curr=curr.next;
                }
                root=root.next;
            }
            root=temp.next;
            temp.next=null;
        }
    }
}
