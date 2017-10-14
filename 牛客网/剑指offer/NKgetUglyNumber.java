import java.util.ArrayList;

public class NKgetUglyNumber {
    public static int GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        ArrayList<Integer> arr=new ArrayList<>();
        int t1,t2,t3;
        int temp;
        t1=t2=t3=0;
        arr.add(1);
        for(int i=1;i<index;i++){
            temp=Math.min(arr.get(t1)*2,Math.min(arr.get(t2)*3,arr.get(t3)*5));
            arr.add(temp);
            if(temp==arr.get(t1)*2)t1++;
            if(temp==arr.get(t2)*3)t2++;
            if(temp==arr.get(t3)*5)t3++;
        }
        return arr.get(index-1);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(5));
    }
}
