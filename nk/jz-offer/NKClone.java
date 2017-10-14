
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class NKClone {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)return null;
        RandomListNode p,p2,head;
        p=pHead;
        while (p!=null){
            RandomListNode node=new RandomListNode(p.label);
            node.next=p.next;
            p.next=node;
            p=node.next;
        }
        p=pHead;
        while (p!=null){
            p2=p.next;
            if(p.random!=null){
                p2.random=p.random.next;
            }
            p=p2.next;
        }
        head=pHead.next;
        p=pHead;
        while (p.next!=null){
            p2=p.next;
            p.next=p2.next;
            p=p2;
        }
        return head;
    }
}
