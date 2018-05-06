/**
 * @author pengsong
 * @date 18/1/27 上午9:08
 */
/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
/*
下面是常规的方法，显然是超时了，因为没有考虑很多情况，直接暴力求解
discuss上面给出了dp的解法，我复制在下面，其实就是将我的flag矩阵改为dp矩阵，当然了，不用全局变量还是很不方便的
 */
public class LC329LongestIncreasingPathinaMatrix {
    static int maxValue = 0;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dfs(matrix, flag, 0, 0, i, j,true);
            }
        }

        return maxValue;
    }

    private static void dfs(int[][] matrix, boolean[][] flag, int num, int preValue, int i, int j,boolean isFisrt) {
        if (isFisrt|| !(preValue >= matrix[i][j])) {
            flag[i][j] = true;
            num+=1;
            if (i - 1 >= 0 && flag[i - 1][j] == false) dfs(matrix, flag, num, matrix[i][j],  i - 1, j,false);
            if (j - 1 >= 0 && flag[i][j - 1] == false) dfs(matrix, flag, num, matrix[i][j],  i, j - 1,false);
            if (i + 1 < matrix.length && flag[i + 1][j] == false) dfs(matrix, flag, num, matrix[i][j], i + 1, j,false);
            if (j + 1 < matrix[0].length && flag[i][j + 1] == false) dfs(matrix, flag, num, matrix[i][j],  i, j + 1,false);
            flag[i][j] = false;
        }
        if (num > maxValue) maxValue = num;
    }

    public static int longestIncreasingPath2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res=Math.max(res,dfs2(matrix, dp, 0,  i, j,true));
            }
        }

        return res;
    }

    private static int dfs2(int[][] matrix, int[][] dp, int preValue, int i, int j,boolean isFisrt) {
        if (isFisrt|| !(preValue >= matrix[i][j])) {
            if(dp[i][j]!=0)return dp[i][j];
            int res=0;
            if (i - 1 >= 0 ) res=Math.max(res,dfs2(matrix, dp,  matrix[i][j],  i - 1, j,false));
            if (j - 1 >= 0 ) res=Math.max(res,dfs2(matrix, dp,  matrix[i][j],  i, j - 1,false));
            if (i + 1 < matrix.length ) res=Math.max(res,dfs2(matrix, dp, matrix[i][j], i + 1, j,false));
            if (j + 1 < matrix[0].length) res=Math.max(res,dfs2(matrix, dp,  matrix[i][j],  i, j + 1,false));
            dp[i][j]=++res;
            return dp[i][j];
        }
        return 0;
    }

    public static void main(String[] args) {
        //System.out.println(longestIncreasingPath2(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        //System.out.println(longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
        //System.out.println(longestIncreasingPath(new int[][]{{1}}));
        //System.out.println(longestIncreasingPath(new int[][]{{3,2,1}}));
        //System.out.println(longestIncreasingPath(new int[][]{{7,7,5},{2,4,6},{8,2,0}}));
    }

    /*
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = findSmallAround(i, j, matrix, cache, Integer.MAX_VALUE);
                max = Math.max(length, max);
            }
        }
        return max;
    }
    private int findSmallAround(int i, int j, int[][] matrix, int[][] cache, int pre) {
        // if out of bond OR current cell value larger than previous cell value.
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
            return 0;
        }
        // if calculated before, no need to do it again
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallAround(i - 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i + 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j - 1, matrix, cache, cur), tempMax);
            tempMax = Math.max(findSmallAround(i, j + 1, matrix, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
     */
}
