import java.util.Stack;

/**
 * @author pengsong
 * @date 17/10/24 上午10:05
 */

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */
public class LC084LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxSum=0;
        int n=heights.length;
        int[][] minValue=new int[n][n];
        int[][] sumMat=new int[n][n];
        //求相邻区域中heights的最小值
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0)minValue[i][j]=heights[j];
                else minValue[i][j]=Math.min(minValue[i-1][j-1],minValue[i-1][j]);
                System.out.print(minValue[i][j]+",");
            }
            System.out.println();
        }
        //求全部情况能组成长方形的最大值
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==0)sumMat[i][j]=heights[j];
                else sumMat[i][j]=(i+1)*minValue[i][j];
                if(maxSum<sumMat[i][j])maxSum=sumMat[i][j];
                System.out.print(sumMat[i][j]+",");
            }
            System.out.println();
        }
        return maxSum;
    }
    //不得不服。。。
    //参考：https://mp.weixin.qq.com/s?__biz=MjM5ODIzNDQ3Mw==&mid=2649965580&idx=1&sn=6c5da010852f54ac917cd65b71dd512b&scene=2&srcid=0628D20JTralYPgZItmYEeTo&from=timeline&isappinstalled=0#wechat_redirect
    //http://blog.csdn.net/yutianzuijin/article/details/52072427
    /*
    有两点很重要：
    如果下标为k的长方形低于下标为k+1的长方形，说明下标为k的长方形一定不是终点
    反之，说明下标为k的长方形有可能是终点

    始终保证栈中元素有序
     */
    public static int largestRectangleArea2(int[] heights){
        Stack<Integer> stack=new Stack<>();
        int max_sum=0;
        int index,curr_sum,temp;
        for(int i=0;!stack.isEmpty()||i<heights.length;){
            if(i==heights.length)temp=-1;
            else temp=heights[i];
            if(stack.isEmpty()||heights[stack.peek()]<=temp){
                stack.push(i);
                i++;
            }
            else {
                index=stack.pop();
                if(stack.isEmpty())curr_sum=heights[index]*i;
                else curr_sum=heights[index]*(i-stack.peek()-1);
                if(curr_sum>max_sum)max_sum=curr_sum;
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[]{2,1,5,6,2,3}));
    }
}
