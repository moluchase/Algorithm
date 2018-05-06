/**
 * @author pengsong
 * @date 18/1/11 上午9:09
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */
/*
参考discuss中排名第一的答案，用状态机解决
 */
public class LC309BestTimetoBuyandSellStockwithCooldown {
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)return 0;
        int s0,s1,s2;
        s0=0;
        s1=-prices[0];
        s2=0;
        for(int i=1;i<prices.length;i++){
            int temp0=s0,temp1=s1;
            s0=Math.max(s0,s2);
            s1=Math.max(s1,temp0-prices[i]);
            s2=temp1+prices[i];
        }
        return Math.max(s0,s2);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
