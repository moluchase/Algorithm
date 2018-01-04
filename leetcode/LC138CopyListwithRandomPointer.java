/**
 * @author pengsong
 * @date 17/12/8 上午8:31
 */
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

public class LC138CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)return null;
        RandomListNode p,q,q2,head2;
        //生成新节点
        p=head;
        while (p!=null){
            RandomListNode temp=new RandomListNode(p.label);
            q=p;//记录当前节点
            p=p.next;//指向下一个节点
            q.next=temp;//当前节点的下一个节点指向temp
            temp.next=p;//temp的下一个节点指向p
        }
        //更新新节点的random值
        p=head;
        while (p!=null){
            if(p.random!=null) p.next.random=p.random.next;//将上一个节点的random值赋给下一个节点的random值
            p=p.next.next;//指向下两个节点
        }
        head2=head.next;
        //还原原链表，生成新链表
        p=head;
        while (p!=null){
            q=p;//记录当前节点
            q2=p.next;//记录下一个节点
            p=p.next.next;
            if(p!=null){
                q.next=p;
                q2.next=p.next;//如果p不为空，将q2指向p的下一个节点
            }else q.next=null;
        }
        return head2;
    }
}
