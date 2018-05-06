import java.util.Arrays;

/**
 * @author pengsong
 * @date 18/1/23 上午8:33
 */
/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.
 */
/*
受不了了，dp也能超时。。。 182/182
然后改了一下第二个for的选取规则，就通过了
 */
public class LC322CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        int MaxValue=amount+1;
        for(int i=0;i<dp.length;i++)dp[i]=MaxValue;
        dp[0]=0;
        for(int i=0;i<coins.length;i++)if(coins[i]<dp.length)dp[coins[i]]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=coins.length-1;j>=0;j--){
                if(i-coins[j]>0)dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5};
        System.out.println(coinChange(coins,11));
    }
}
