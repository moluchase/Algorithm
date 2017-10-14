import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NKFindContinuousSequence {

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrs=new ArrayList<>();
        Queue<Integer> list=new LinkedList<>();
        int result=0;
        int i=1;
        if(sum==0)return arrs;
        while (i<=(sum+1)/2){
            if(result<sum){
                list.add(i);
                result+=i;
                i++;
            }
            if(result>sum){
                result-=list.poll();
            }
            if(result==sum) {
                arrs.add(new ArrayList<>(list));
                result-=list.poll();
            }
        }
        for(int index=0;index<arrs.size();index++){
            for(int j=0;j<arrs.get(index).size();j++){
                System.out.print(arrs.get(index).get(j)+",");
            }
            System.out.println();
        }
        return arrs;
    }

    public static void main(String[] args) {
        FindContinuousSequence(3);
    }
}
