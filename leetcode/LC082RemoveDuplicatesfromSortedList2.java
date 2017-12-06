/**
 * @author pengsong
 * @date 17/10/24 上午9:29
 */

/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */

/*
这里要求不能使用Map之类的，即保证空间复杂度为O(1)
我之前花了2个多小时的时间想出一种方法，就是每次只找第一个不重复的节点，将问题变成求解这个子问题，然后再将返回的节点连接起来
后面剑值offer上直接设置一个哑元节点来求解，leetcode上的discuss也是如此，下面就用这种方法
 */
public class LC082RemoveDuplicatesfromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode node=new ListNode(0);
        ListNode pre;
        pre=node;
        pre.next=head;
        while (head!=null){
            while (head.next!=null&&head.val==head.next.val)head=head.next;
            if(pre.next==head)pre=pre.next;
            else pre.next=head.next;
            head=head.next;
        }
        return node.next;
    }
}
