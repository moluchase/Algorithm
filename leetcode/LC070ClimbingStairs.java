public class LC070ClimbingStairs {
    public static int climbStairs(int n) {
        /*
        if(n==0)return 0;
        if(n==1)return 1;
        return climbStairs(n-1)+climbStairs(n-2);
        */
        int [] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i==0)dp[i]=0;
            else if(i==1)dp[i]=1;
            else dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
