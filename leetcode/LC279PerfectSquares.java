import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pengsong
 * @date 18/1/5 上午9:41
 */
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
given n = 13, return 2 because 13 = 4 + 9.
 */
public class LC279PerfectSquares {
    //static int res=Integer.MAX_VALUE;
    public static int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        int k1,k2=0,res=0;
        int temp=1;
        for (int i=1;temp<=n;){
            list.add(temp);
            ++i;
            temp=i*i;
        }
        for(Integer i:list) System.out.print(i+",");
        System.out.println();
        queue.add(n);
        k1=1;
        while (!queue.isEmpty()){
            n=queue.poll();
            if(n==0)return res;
            for(int i=list.size()-1;i>=0;i--){
                if(n<list.get(i))continue;
                if(n-list.get(i)==0)return res+1;
                queue.add(n-list.get(i));
                k2++;
            }
            k1--;
            if(k1==0){k1=k2;k2=0;res++;}

        }
        return -1;
        //numSquares(list,n,0);
       // return res;
    }
    public static int numSquares2(int n) {
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++)dp[i]=Integer.MAX_VALUE;
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
/*
    private static void numSquares(List<Integer> list, int n, int number) {
        if(n==0){
            res=Math.min(res,number);
            return;
        }
        for(int i=list.size()-1;i>=0;i--){
            if(n<list.get(i))continue;
            numSquares(list,n-list.get(i),number+1);
        }
    }
*/
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
