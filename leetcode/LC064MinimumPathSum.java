public class LC064MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][] flag=new int[n][m];
        for (int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1&&j==m-1)flag[i][j]=grid[i][j];
                else if(i==n-1)flag[i][j]=grid[i][j]+flag[i][j+1];
                else if(j==m-1)flag[i][j]=grid[i][j]+flag[i+1][j];
                else flag[i][j]=grid[i][j]+Math.min(flag[i+1][j],flag[i][j+1]);
            }
        }
        return flag[0][0];
    }
}
