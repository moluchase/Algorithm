/**
 * @author pengsong
 * @date 17/12/11 上午8:17
 */
/*
Sort a linked list in O(n log n) time using constant space complexity.
用快排超时了 14/15
这里就用归并了
 */
public class LC148SortList {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;

        ListNode temp=new ListNode(0);
        ListNode parm,p,p2,pre;
        parm=head;
        p=head.next;
        p2=temp;
        pre=head;
        while (p!=null){
            if(p.val<parm.val){
                if(temp.next==null){
                    temp.next=p;
                    p2=p;
                }else {
                    p2.next=p;
                    p2=p;
                }
                pre.next=p.next;
            }else {
                pre=p;
            }
            p=p.next;
        }
        p2.next=null;
        /*

        ListNode pre,slow,fast;
        pre=null;
        slow=fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        */
        ListNode l1=sortList(temp.next);
        ListNode l2=sortList(head.next);
        head.next=l2;

        return merge(l1,head);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp=new ListNode(0);
        ListNode p;
        p=temp;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1!=null)p.next=l1;
        if(l2!=null)p.next=l2;
        return temp.next;
    }
}
