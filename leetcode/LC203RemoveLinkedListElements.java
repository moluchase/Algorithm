/**
 * @author pengsong
 * @date 17/12/21 上午9:40
 */
/*
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */
/*
亚元节点
 */
public class LC203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p,pre;
        ListNode node =new ListNode(0);
        node.next=head;
        pre=node;
        p=head;
        while (p!=null){
            if(p.val==val)pre.next=p.next;
            else pre=p;
            p=p.next;
        }
        return node.next;
    }
}
