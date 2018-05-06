/**
 * @author pengsong
 * @date 18/3/10 下午7:58
 */
public class LC010RegularExpression {
    public static boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean [][]dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=0;i<m;i++){
            if(p.charAt(i)=='*')dp[0][i+1]=dp[0][i-1];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')dp[i+1][j+1]=dp[i][j];
                if(p.charAt(j)=='*'){
                    if(s.charAt(i)!=p.charAt(j-1)&&p.charAt(j-1)!='.')dp[i+1][j+1]=dp[i+1][j-1];
                    else dp[i+1][j+1]=dp[i+1][j-1]||dp[i+1][j]||dp[i][j+1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        isMatch("aa","a");
    }
}
