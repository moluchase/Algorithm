import java.util.Arrays;

/**
 * @author pengsong
 * @date 17/11/22 上午9:45
 */

/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
 */

/*
这道题就是给定一个序列，从中选择两个数，使这两个数的差最大
 */
public class LC121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)return 0;
        if(prices.length==1)return 0;
        int day=prices.length;
        int[]temp=new int[day-1];
        int minValue=prices[0];
        for(int i=1;i<day;i++){
            temp[i-1]=prices[i]-minValue;
            if(minValue>prices[i])minValue=prices[i];
        }
        Arrays.sort(temp);
        if(temp[temp.length-1]<0)return 0;
        else return temp[temp.length-1];
    }
}
