
class ListNode(object):
    def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head==None or head.next==None:
            return head
        h=head.next
        while(head!=None and head.next!=None):
            p1=head
            p2=head.next
            temp=p1
            p1.next=p2.next
            p2.next=temp
            head=p1.next
        return h