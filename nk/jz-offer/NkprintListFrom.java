import java.util.ArrayList;

class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}


public class NkprintListFrom {
    public ArrayList<Integer> printTail(ListNode p,ArrayList<Integer> arr){
        if(p!=null){
            arr=printTail(p.next,arr);
            arr.add(p.val);
        }
        return arr;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr=new ArrayList<>();
        return printTail(listNode,arr);
    }
}
