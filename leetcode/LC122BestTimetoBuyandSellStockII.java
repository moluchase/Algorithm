/**
 * @author pengsong
 * @date 17/11/22 上午9:59
 */

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit.
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

/*
。。。。理解题意：当天只能进行一次交易和当天同时卖出再买入是一个效果
 */
public class LC122BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])res+=prices[i]-prices[i-1];
        }
        return res;
    }
}
