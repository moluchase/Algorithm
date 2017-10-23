public class LC063UniquePath2 {
    /*
    如果该位置是1直接返回0
    否者如果该位置是最后一个位置，返回1
    否者如果该位置在最下面一行，等于该位置右边那个位置
    否者如果该位置在最右边一行，等于该位置下面的那个位置
    否者等于该位置右边那个位置加上下面那个位置
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][]flag=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(obstacleGrid[i][j]==1)flag[i][j]=0;
                else if(i==n-1&&j==m-1)flag[i][j]=1;
                else if(i==n-1)flag[i][j]=flag[i][j+1];
                else if(j==m-1)flag[i][j]=flag[i+1][j];
                else flag[i][j]=flag[i+1][j]+flag[i][j+1];
            }
        }
        return flag[0][0];
    }
}
