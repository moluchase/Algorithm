/**
 * @author pengsong
 * @date 17/12/22 上午9:04
 */
/*
Reverse a singly linked list.
 */
/*
很简单
 */
public class LC206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode pre,p;
        pre=head;
        p=head.next;
        head.next=null;
        while (p!=null){
            ListNode temp=p.next;
            p.next=pre;
            if(temp==null)return p;
            pre=p;
            p=temp;
        }
        return pre;
    }
}
