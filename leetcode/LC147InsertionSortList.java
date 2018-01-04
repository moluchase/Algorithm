/**
 * @author pengsong
 * @date 17/12/10 上午9:54
 */
/*
Sort a linked list using insertion sort.
 */
public class LC147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode p,pre,pre2,plas;
        ListNode node=new ListNode(0);
        boolean flag=false;
        node.next=head;
        pre=node;
        p=head;
        while (p!=null){
            plas=p.next;
            ListNode temp=node.next;
            pre2=node;
            while (temp.next!=plas){
                if(temp.val>p.val){
                    pre.next=p.next;
                    pre2.next=p;
                    p.next=temp;
                    flag=true;
                    break;
                }
                pre2=temp;
                temp=temp.next;
            }
            if(flag!=true)pre=p;
            else flag=false;
            p=plas;
        }
        return node.next;
    }
}
