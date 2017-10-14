public class NKEntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1,p2;
        p1=pHead.next;
        p2=pHead.next.next;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
        }
        //if (p2==null||p2.next==null)return null;
        p2=pHead;
        while (p2!=p1){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
