package interview;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author pengsong
 * @date 18/4/22 下午8:36
 */
public class finTech01 {

    public static int theNum(int k,int[]arr){
        int []dp=new int[k+1];
        Arrays.sort(arr);
        ArrayList<Integer> arrlist=new ArrayList<>();
        for(int i=0;i<arr.length;i++)arrlist.add(arr[i]);
        dp[0]=0;
        for(int i=1;i<=k;i++){
            if(arrlist.contains(i))dp[i]=1;
            dp[i]+=dp[i-1];
            for(int j=2;j<i;j++){
                if(arrlist.contains(i-j)&&i-j>=j)dp[i]++;
            }
            System.out.println("dp["+i+"]"+dp[i]);
        }
        return dp[k];
    }
    static int num=0;
    public static void dfs(int k,int cur,int[]arr,int j){
        if(cur==k)num++;
        else if(cur<k){
            for(int i=j;i<arr.length;i++){
                dfs(k,cur+arr[i],arr,i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(theNum(7,new int[]{1,2,5}));
        dfs(7,0,new int[]{1,2,5},0);
        System.out.println(num);
    }
}
