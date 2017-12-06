/**
 * @author pengsong
 * @date 17/12/5 上午8:30
 */

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */

/*
这道题我是无能为力了，只能想到dp先计算第i个字符到第j个字符之间的回文关系，然后再用dfs作遍历
dfs遍历过程中确实会出现重复的过程,我将dfs过程从后开始，然后设置一个判断返回的过程，虽然通过的test多了几个，但是还是没过26/29
这道题估计得使用dp+dp
在leetcode上看到的解法如下
This can be solved by two points:

cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
The 2nd point reminds us of using dp (caching).
//https://discuss.leetcode.com/topic/32575/easiest-java-dp-solution-97-36
 */
public class LC132PalindromePartitioningII {
    public static int minCut(String s) {
        int end=s.length();
        boolean [][]dp=new boolean[end][end];
        int[]maxCount=new int[1];
        maxCount[0]=Integer.MAX_VALUE;
        for(int i=0;i<end;i++){
            for(int j=0;j<=i;j++){
                if(i==j)dp[j][i]=true;
                else dp[j][i]=(s.charAt(i)==s.charAt(j))&&((i-j<=1)||dp[j+1][i-1]);
                //System.out.println("dp["+j+"]["+i+"]="+dp[j][i]);
            }
        }
        dfs(dp,0,end,0,maxCount);
        return maxCount[0];
    }

    private static void dfs(boolean[][] dp, int i,int end, int count,int[]maxCount) {
        if(count>maxCount[0])return;
        if(i==end||dp[i][end-1]){
            if(count<maxCount[0])maxCount[0]=count;
        };
        for(int j=end-1;j>=i;j--){
            if(dp[i][j]){
                dfs(dp,j+1,end,count+1,maxCount);
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(minCut("ab"));
    }
}
/*
public int minCut(String s) {
    char[] c = s.toCharArray();
    int n = c.length;
    int[] cut = new int[n];
    boolean[][] pal = new boolean[n][n];

    for(int i = 0; i < n; i++) {
        int min = i;
        for(int j = 0; j <= i; j++) {
            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                pal[j][i] = true;
                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
            }
        }
        cut[i] = min;
    }
    return cut[n - 1];
}
 */
