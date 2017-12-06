/**
 * @author pengsong
 * @date 17/11/18 下午10:46
 */

/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */

/*
题目的意思是说，从s中不同位置选择字符组成的子串和t相等的有多少个？
就如Grandyang所说，看到有关字符串的子序列或配准类的问题，首先考虑用动态规划来解决
构建DP矩阵
dp[i+1][j+1]表示s[0..j]和t[0..i]中不同的子串数，那么问题的解就是dp[t.length+1][s.length+1]
继续分析
边界条件：
dp[0][j]表示t为空串，那么对于任意长度的j，它的子串一定包含空串，即dp[0][j]=1
dp[i][0]表示s为空串，如果t不为空串，那么s的子串只有空串，也就不可能和t相等，即dp[i][0]=0
当t为空串时，即dp[0][0]=1
递推公式：
对于任意的i,j >0
如果t[i]=s[j],那么dp[i+1][j+1]=dp[i+1][j]+dp[i][j]
如果t[i]!=s[j],那么dp[i+1][j+1]=dp[i+1][j]
##
此处这样理解：对于长度为i+1的t串和长度为j+1的s串，如果第i个元素和第j个元素相等，其不同的子串等于下面两种情况的和
1.同时去掉这两个元素后，不同子串的个数
2. s串去掉第j个元素后，不同子串的个数

如果第i个元素和第j个元素不相等，上面的第1种情况就没有了，因为不能去掉t中的第i个元素

当然这个矩阵中i>j的值很显然为0

参考：https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java
 */
public class LC115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [][]dp=new int[m+1][n+1];
        for(int j=0;j<=n;j++)dp[0][j]=1;
        for(int i=1;i<=m;i++){
            for(int j=i;j<=n;j++){
                if(t.charAt(i-1)==s.charAt(j-1))dp[i][j]=dp[i-1][j-1];
                dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
