import java.util.ArrayList;

/**
 * @author pengsong
 * @date 17/11/16 上午8:53
 */

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
/*
这种题目如果是我做的话，当然是很复杂的方法了，所以直接参考别人的方法，这里给出两种，都非常经典
1.使用中序遍历的思想解决，时间复杂度是O(n)
参考：http://blog.csdn.net/linhuanmars/article/details/23904937
这种解法中提到的空间复杂度为O(lgn)是有问题的，而且写着有点让人不好理解，其实直接用全局变量反而好理解
2.使用快慢指针来解决，核心之处在于根节点是二分点得节点
参考：https://discuss.leetcode.com/topic/35997/share-my-java-solution-1ms-very-short-and-concise

 */
public class LC109ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)return null;
        ArrayList<ListNode>list=new ArrayList<>();
        list.add(head);
        int num=0;
        while (head!=null){
            num++;
            head=head.next;
        }
        return helper(0,num-1,list);
    }

    private TreeNode helper(int s, int e,ArrayList<ListNode>list) {
        if(s>e)return null;
        int mid=(s+e)/2;
        TreeNode left=helper(s,mid-1,list);
        TreeNode node=new TreeNode(list.get(0).val);
        node.left=left;
        list.set(0,list.get(0).next);
        TreeNode right=helper(mid+1,e,list);
        node.right=right;
        return node;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(0,44);
        System.out.println("1:"+list.get(0)+",2:"+list.get(1));
    }
}
