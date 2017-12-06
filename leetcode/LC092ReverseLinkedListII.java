/**
 * @author pengsong
 * @date 17/11/9 上午8:59
 */

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */

/*
这道题的原始要求是空间复杂度为O(1)，而且要求只遍历一遍
当然我想到的是用递归来解决，这样必然很繁琐
最好的办法是正序，记录第m-1个节点，第m个节点，从第m个节点到第n个节点之间依次将后一个节点的next指向前一个节点，最后连接
 */
public class LC092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p,pm1,pm2,pn,pre;
        ListNode dummy=new ListNode(-1);//亚元节点
        dummy.next=head;
        pre=dummy;
        p=head;
        for(int i=1;i<m;i++){
            pre=p;
            p=p.next;
        }
        pm1=pre;
        pm2=p;
        pre=p;
        p=p.next;
        pn=p;
        for(int i=m;i<n;i++){
            pn=p.next;
            p.next=pre;
            pre=p;
            p=pn;
        }
        pm1.next=pre;
        pm2.next=pn;
        return dummy.next;
    }
}
