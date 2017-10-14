import java.lang.ref.PhantomReference;

public class NKdeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null)return null;
        ListNode p= pHead;
        ListNode p1=null,p2,head=null;
        while (p!=null){
            if(p1==null){
                p1=getHead(p);
                head=p1;
                p=p1!=null?p1.next:null;
            }else {
                p2=getHead(p);
                p1.next=p2;
                p1=p2;
                p=p2!=null?p2.next:null;
            }
        }
        return head;
    }

    private static ListNode getHead(ListNode p) {
        if(p.next==null)return p;
        ListNode p2;
        p2=p;
        while (p.next!=null&&p.val==p.next.val)p=p.next;
        if(p==p2)return p2;
        else if(p.next==null) return null;
        return getHead(p.next);
    }

    public static void main(String[] args) {
        ListNode listNode=createList(new int[]{1,1,1,1,3,5,5});
        listNode=deleteDuplication(listNode);
        //prt(listNode);
        printList(listNode);
    }

    private static void prt(ListNode listNode) {
        listNode=listNode.next;
    }

    private static void printList(ListNode listNode) {
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    private static ListNode createList(int[] ints) {
        ListNode listNode=new ListNode(ints[0]);
        ListNode p=listNode;
        for(int i=1;i<ints.length;i++){
            ListNode listNode1=new ListNode(ints[i]);
            p.next=listNode1;
            p=p.next;
        }
        p.next=null;
        return listNode;
    }

    /*
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p1,p2;
        if(pHead==null)return null;
        p1=pHead;
        p2=pHead.next;
        while (p2!=null){
            if(p2.val==p1.val){
                p1.next=p2.next;
                p2=p1.next;
            }else {
                p1=p2;
                p2=p2.next;
            }
        }
        return pHead;
    }
     */
}
