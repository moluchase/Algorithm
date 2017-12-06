/**
 * @author pengsong
 * @date 17/10/24 上午9:52
 */
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
/*
这个之于前面那道题，就简单了很多
 */
public class LC083RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode p1,p2;
        p1=head;
        p2=head.next;
        while (p2!=null){
            if(p2.val!=p1.val){
                p1.next=p2;
                p1=p1.next;
            }
            p2=p2.next;
        }
        p1.next=null;
        return head;
    }
}
