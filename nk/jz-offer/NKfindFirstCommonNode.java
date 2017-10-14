public class NKfindFirstCommonNode {

    public ListNode getCommon(ListNode h1,ListNode h2,int num){
        while (num>0){
            h1=h1.next;
            num--;
        }
        while (h1!=null&&h1!=h2){
            h1=h1.next;
            h2=h2.next;
        }
        return h1;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1,length2;
        length1=length2=0;
        ListNode h=pHead1;
        while (h!=null){
            length1++;
            h=h.next;
        }
        h=pHead2;
        while (h!=null){
            length2++;
            h=h.next;
        }
        if(length1>length2){
            return getCommon(pHead1,pHead2,length1-length2);
        }else {
            return getCommon(pHead2,pHead1,length2-length1);
        }
    }
}
