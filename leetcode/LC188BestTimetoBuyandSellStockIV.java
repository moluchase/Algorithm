import java.util.*;

/**
 * @author pengsong
 * @date 17/12/19 上午9:34
 */
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
/*
写了好久啊，40分钟了，我想把自己想的写下来，结果写了这么久，而且还是错的，是在下高估自己了，以后绝不轻易动笔了
 */
public class LC188BestTimetoBuyandSellStockIV {
    public static int maxProfit(int k, int[] prices) {
        if(prices.length<2)return 0;
        int []bias=new int[prices.length-1];//保证数组长度大于1
        Map<String,Integer> map= new HashMap<>();
        int res=0;
        for(int i=1;i<prices.length;i++){
            bias[i-1]=prices[i]-prices[i-1];
        }
        int indexS,indexE;
        indexS=0;
        for(int i=0;i<bias.length;i++){
            int sum=0;
            if(bias[i]>0){
                indexE=indexS;
                while (i<bias.length&&bias[i]>0){
                    indexE++;
                    sum+=bias[i];
                    i++;
                }
                String temp=indexS+"#"+indexE;
                map.put(temp,sum);
                indexS=indexE;
            }
            indexS++;
        }
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i=0;i<list.size();i++){
            if(i>=list.size())return res;//没想到这个情况，如果list的大小小于k呢；还有一种情况，如果list的大小大于k呢，直接导致程序重写，悲剧，我不想改了
            res+=list.get(i).getValue();
            System.out.println(list.get(i).getKey()+"="+list.get(i).getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("1,2,4,2,5,7,2,4,9,0");
        maxProfit(3,new int[]{1,2,4,2,5,7,2,4,9,0});
    }
}
