/**
 * @author pengsong
 * @date 17/10/26 上午9:05
 */

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 */

/*
解决的办法就是问题分解
求n*m的矩阵中最大的连1矩阵等于于求下面三个子问题的最大值
1. (n-1)*m的矩阵中最大的连1矩阵
2. n*(m-1)的矩阵中最大的连1矩阵
3. n*m矩阵中包含[n,m]点得最大连1矩阵

如上，可以转为DP问题求解
实在是不知道怎么解第3个子问题了，。。。可以参考discuss中O(n^2)的DP解法
 */
public class LC085MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][]dp1=new int[n][m];//解决第3个子问题
        int [][]dp2=new int[n][m];//解决原问题
        int[][]right=new int[n][m];
        int[][]down=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(j==m-1)right[i][j]=matrix[i][j];
                else right[i][j]=matrix[i][j]==1?1+right[i][j+1]:0;
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1)down[i][j]=matrix[i][j];
                else down[i][j]=matrix[i][j]==1?1+down[i+1][j]:0;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1&&j==m-1)dp1[i][j]=matrix[i][j];
                else if(i==n-1)dp1[i][j]=matrix[i][j]==1?dp1[i][j+1]+1:0;
                else if(j==m-1)dp1[i][j]=matrix[i][j]==1?dp1[i+1][j]+1:0;
                else {
                    if(matrix[i][j]==0)dp1[i][j]=0;
                    else if(dp1[i+1][j]==0&&dp1[i][j+1]==0)dp1[i][j]=1;
                    else if(dp1[i+1][j]>0&&dp1[i][j+1]>0){
                       // Math.min(right[i][j+1]+1)
                    }else if(dp1[i+1][j]>0)dp1[i][j]=down[i][j];
                    else if(dp1[i][j+1]>0)dp1[i][j]=right[i][j];
                }
            }
        }
        return 0;
    }
}
