public class LC062UniquePaths {

    //有记忆的便利（DFS的反向）
    public int uniquePaths(int m, int n) {
        int[][] flag=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0)flag[i][j]=1;
                else flag[i][j]=flag[i-1][j]+flag[i][j-1];
            }
        }
        return flag[m-1][n-1];
    }

    /*
    //使用DFS做，但是不是有记忆的，这样会有很多重复的
    public int uniquePaths(int m, int n) {
        return getUniquePathNum(m,n,1,1);
    }

    private int getUniquePathNum(int m, int n, int i, int j) {
        if(i==m&&j==n)return 1;
        if(i>m||j>n)return 0;
        return getUniquePathNum(m,n,i+1,j)+getUniquePathNum(m,n,i,j+1);
    }
     */

}
