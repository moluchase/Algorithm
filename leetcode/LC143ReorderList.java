/**
 * @author pengsong
 * @date 17/12/9 上午9:13
 */

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
/*
链表问题都比较简单,但是我再也不会做了，做一遍已经够了，而且没有意义
 */
public class LC143ReorderList {
    public static void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return;
        int n,m;
        n=m=0;
        ListNode p,p2,q,q2,pre;
        p=p2=head;
        while (p!=null){
            n++;
            p=p.next;
        }
        n/=2;
        pre=head;
        while ((++m)<=n){
            pre=p2;
            p2=p2.next;
        }
        pre.next=null;
        p=p2;
        q=p.next;
        p.next=null;
        while (q!=null){
            q2=q.next;
            q.next=p;
            p=q;
            q=q2;
        }
        q=head;
        while (p!=null&&q!=null){
            p2=p.next;
            q2=q.next;
            q.next=p;
            if(q2!=null)p.next=q2;
            p=p2;
            q=q2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode=createListNode(new int[]{1,2,3,4});
        reorderList(listNode);
        printListNode(listNode);
    }

    private static void printListNode(ListNode listNode) {
        ListNode p=listNode;
        int i=0;
        while (p!=null){
            System.out.print(p.val+",");
            p=p.next;
            if((++i)>6)break;
        }
    }

    private static ListNode createListNode(int[] arr) {
        ListNode head=new ListNode(arr[0]);
        int i=1;
        ListNode q=head;
        while (i<arr.length){
            ListNode p=new ListNode(arr[i]);
            q.next=p;
            q=p;
            i++;
        }
        q.next=null;
        return head;
    }
}
