public class LC061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        int num=0;
        ListNode p,p1;
        p=head;
        while (p!=null){
            num++;
            p=p.next;
        }
        if(k%num==0||num==1)return head;
        k=num-k%num;
        num=1;
        p=head;
        while (num<k){
            p=p.next;
            num++;
        }
        p1=p.next;
        p.next=null;
        p=p1;
        while (p.next!=null){
            p=p.next;
        }
        p.next=head;
        return p1;
    }
}
