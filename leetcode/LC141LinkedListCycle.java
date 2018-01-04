/**
 * @author pengsong
 * @date 17/12/9 上午8:37
 */
/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LC141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1,p2;
        p1=p2=head;
        while (p1!=null&&p1.next!=null){
            p1=p1.next.next;
            p2=p2.next;
            if(p1==p2)return true;
        }
        return false;
    }
}
