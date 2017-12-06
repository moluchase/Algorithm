/**
 * @author pengsong
 * @date 17/11/22 上午10:31
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/*
这道题的难度已经超出了我的范围，我只能看discuss了
第一种解法：
dp
dp(k,i)在price[i]后进行了k次交易所获得的最大利润
dp(k,i)=max(dp(k,i-1),max(price(i)-price(j)+dp(k-1,j)));
其中的j表示小于i的数
参考：https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions

第二种解法太经典了，很取巧
用4个变量分别表示第一次买入，第一次卖出，第二次买入，第二次卖出
至于代码中4行的顺序，应该是先卖出然后买入，如果先买入再卖出就相当于当天买当天卖，没意义，
同理第二次买卖应该在第一次之前，即代码顺序上应该是先第二次，后第一次
还是直接看代码吧
 */

public class LC123BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        int [][]dp=new int[3][prices.length];//这里k=2
        for(int k=1;k<=2;k++){
            int tmpMax=dp[k-1][0]-prices[0];//表示的是第0次卖出
            for(int i=1;i<prices.length;i++){
                dp[k][i]=Math.max(dp[k][i-1],prices[i]+tmpMax);
                tmpMax=Math.max(tmpMax,dp[k-1][i]-prices[i]);
            }
        }
        return dp[2][prices.length-1];
    }

    public int maxProfit2(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }

}
