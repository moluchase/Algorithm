/**
 * @author pengsong
 * @date 17/12/13 上午8:27
 */
/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */
/*
剑指offer上的一道题，easy
 */
public class LC160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la,lb;
        ListNode pa,pb;
        la=lb=0;
        pa=headA;
        pb=headB;
        while (pa!=null){
            la++;
            pa=pa.next;
        }
        while (pb!=null){
            lb++;
            pb=pb.next;
        }
        int k=0;
        pa=headA;
        pb=headB;
        if(la>lb){
            while (k<la-lb){
                pa=pa.next;
                k++;
            }
        }else {
            while (k<lb-la){
                pb=pb.next;
                k++;
            }
        }
        while (pa!=null&&pa!=pb){
            pa=pa.next;
            pb=pb.next;
        }
        return pa;
    }
}
