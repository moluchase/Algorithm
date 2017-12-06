/**
 * @author pengsong
 * @date 17/11/11 下午5:24
 */

/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */

/*
这道题给我的感觉并不难，虽然是hard,然后通过99/101
感觉又得用DP
记住：只要是遇到字符串的子序列或是匹配问题直接就上动态规划Dynamic Programming，其他的都不要考虑
构建矩阵dp[n][m]
n表示s1的长度，m表示s2的长度
dp[i][j]表示s1的前i个字符串，s2的前j个字符串和s3的前i+j个字符串匹配
有如下公式：
dp[0][0]=true
dp[i][0]=dp[i-1][0]&&s1[i-1]==s3[i-1]  ; i>=1
dp[0][j]=dp[0][j-1]&&s2[j-1]==s3[j-1]  ; j>=1
dp[i][j]=(dp[i-1][j]&&s1[i-1]==s3[i+j-1])
 */
public class LC097InterleavingString {
    //下面这种方法是DFS
    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterDfs(s1,s2,s3,"","");
    }

    private static boolean isInterDfs(String s1, String s2, String s3, String cur1, String cur2) {
        if(cur1.length()==s1.length()||cur2.length()==s2.length()){
            if(cur1.length()==s1.length())return s1.equals(cur1)&&s2.equals(cur2+s3);
            else return s1.equals(cur1+s3)&&s2.equals(cur2);
        }
        boolean flag=false;
        if(s3.charAt(0)==s1.charAt(cur1.length())){
            flag=flag||isInterDfs(s1,s2,s3.substring(1),cur1+s3.substring(0,1),cur2);
        }
        if(flag==true)return true;
        else if(s3.charAt(0)==s2.charAt(cur2.length())){
            flag=flag||isInterDfs(s1,s2,s3.substring(1),cur1,cur2+s3.substring(0,1));
        }
        return flag;
    }

    //DP解法
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length())return false;
        int n=s1.length();
        int m=s2.length();
        boolean dp[][]=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1);
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=dp[0][j-1]&&s2.charAt(j-1)==s3.charAt(j-1);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        //System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        isInterleave2("","b","b");
    }
}
