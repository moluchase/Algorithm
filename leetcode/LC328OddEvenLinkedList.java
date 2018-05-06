/**
 * @author pengsong
 * @date 18/1/25 上午8:57
 */
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.
 */
/*
这种链表的题目我早就说过不想再做了，一点意思都没有。。。
 */
public class LC328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode node=new ListNode(0);
        ListNode p=head,q=head.next;
        node.next=q;
        while (p.next!=null&&q!=null){
            p.next=q.next;
            if(p.next!=null)p=p.next;
            if(p.next!=null){
                q.next=p.next;
                q=q.next;
            }
        }
        q.next=null;
        p.next=node.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
