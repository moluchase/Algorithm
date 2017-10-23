/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 */

/*
DP问题
写出通项公式即可
即：对于长度为n和m的两个字符串比较：
要么比较n-1和m【删除长度为n的字符串的最后一个元素】
要么比较n和m-1【删除长度为m的字符串的最后一个元素】
要么比较n-1和m-1【这两个字符串最后一个元素相等，或者替换其中一个元素使之相等】

接下来分析初始条件
长度为0的字符串和长度为k的字符串比较，需要编辑k步【要么删除长度为k的字符串，要么增加长度为0的字符串】
反之一样

采用自顶向下的方法【有记忆，避免重复计算】

参见：http://blog.csdn.net/feliciafay/article/details/17502919
 */

public class LC072EditDistance {
    public int minDistance(String word1, String word2) {
        int n=word1.length()+1;//此处是从0到n，即包括0，也包括n
        int m=word2.length()+1;
        int [][]dp=new int[n][m];
        int temp1,temp2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0)dp[i][j]=j;
                else if(j==0)dp[i][j]=i;
                else{
                    temp1=dp[i-1][j]<dp[i][j-1]?dp[i-1][j]+1:dp[i][j-1]+1;//删除
                    if(word1.charAt(i-1)==word2.charAt(j-1))temp2=dp[i-1][j-1];//相等
                    else temp2=dp[i-1][j-1]+1;//替换
                    dp[i][j]=Math.min(temp1,temp2);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
