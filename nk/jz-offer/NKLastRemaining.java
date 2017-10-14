import java.util.ArrayList;

public class NKLastRemaining {
    //n大于0
    public static int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> arr=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++) arr.add(i);
        while (arr.size()>1){
            index=(arr.size()+(index+m)%arr.size()-1)%arr.size();
            arr.remove(index);
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(10,2));
    }
}
