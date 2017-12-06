/**
 * @author pengsong
 * @date 17/10/28 上午9:56
 */

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */

/*
链表和排序联系到一起，一般的做法好像特别喜欢使用哑元节点

这道题就是这样的，一个哑元指向小于x的节点，一个哑元指向大于x的节点，然后将小于x的链表和大于x的链表连接起来
 */
public class LC086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode node1,node2,p1,p2;
        node1=new ListNode(0);
        node2=new ListNode(0);
        p1=node1;
        p2=node2;
        while (head!=null){
            if(head.val<x){
                p1.next=head;
                p1=head;
            }else {
                p2.next=head;
                p2=head;
            }
            head=head.next;
        }
        p2.next=null;
        p1.next=node2.next;
        return node1.next;
    }
}
