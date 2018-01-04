/**
 * @author pengsong
 * @date 17/12/9 上午8:54
 */

/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
/*
easy
 */
public class LC142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode p1,p2;
        p1=p2=head;
        while (p1!=null&&p1.next!=null){
            p1=p1.next.next;
            p2=p2.next;
            if(p1==p2)break;
        }
        if(p1==null||p1.next==null)return null;
        p1=head;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
