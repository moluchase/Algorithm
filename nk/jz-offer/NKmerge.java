import com.sun.deploy.util.ParameterUtil;

public class NKmerge {

    public static void main(String[] args) {
        ListNode list1,list2,p;
        list1=new ListNode(1);
        list2=new ListNode(2);
        p=list1;
        for(int i=2;i<4;i++){
            ListNode temp=new ListNode(i*2-1);
            p.next=temp;
            p=temp;
        }
        p.next=null;
        p=list2;
        for(int i=2;i<4;i++){
            ListNode temp=new ListNode(i*2);
            p.next=temp;
            p=temp;
        }
        p.next=null;

        /*
        while (list2!=null){
            System.out.println(list2.val);
            list2= list2.next;
        }
        */
        p= Merge(list1,list2);
        while (p!=null){
            System.out.println(p.val);
            p= p.next;
        }
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1,p2,p,head;
        p1=list1;
        p2=list2;
        p=null;
        head=null;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                if(head==null){
                    p=p1;
                    head=p1;
                }else{
                    p.next=p1;
                    p=p1;
                }
                p1=p1.next;
            }else{
                if(head==null){
                    p=p2;
                    head=p2;
                }else{
                    p.next=p2;
                    p=p2;
                }
                p2=p2.next;
            }
        }
        if(p1==null){
            while(p2!=null){
                if(head==null){
                    p=p2;
                    head=p2;
                }else{
                    p.next=p2;
                    p=p2;
                }
                p2=p2.next;
            }
        }else{
            while(p1!=null){
                if(head==null){
                    p=p1;
                    head=p1;
                }else{
                    p.next=p1;
                    p=p1;
                }
                p1=p1.next;
            }
        }
        return head;
    }
}
