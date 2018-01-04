/**
 * @author pengsong
 * @date 18/1/3 上午9:14
 */
/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
/*
吐血，第一个方法没过。。。
判断回文也就这两种方法了，第二种倒是和listNode有点关系，然后通过了，
第一种不知道为什么TLE了，24/25，时间复杂度和空间复杂度好像都满足吧
 */
public class LC234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        StringBuilder temp1,temp2;
        temp1=new StringBuilder("");
        temp2=new StringBuilder("");
        while (head!=null){
            temp1.append(head.val);
            temp2.insert(0,head.val);
            head=head.next;
        }
        if(temp1.toString().equals(temp2.toString()))return true;
        return false;
    }
    public boolean isPalindrome2(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode slow,fast;
        slow=fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=reverse(slow);
        slow=head;
        while (fast!=null){
            if(fast.val!=slow.val)return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode p1,p2;
        p1=slow;
        p2=slow.next;
        while (p2!=null){
            ListNode temp=p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
        }
        slow.next=null;
        return p1;
    }
}
