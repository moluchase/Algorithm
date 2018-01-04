/**
 * @author pengsong
 * @date 17/12/21 上午8:41
 */
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 */
/*
计算岛屿的数量，这种题目之前有类似的，直接dfs
 */
public class LC200NumberofIslands {
    public int numIslands(char[][] grid) {
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!='0'){
                    dfs(grid,i,j);
                    num++;
                }
            }
        }
        return num;
    }
    //进来的是1得情况
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j]='0';
        if(i>0&&grid[i-1][j]=='1')dfs(grid,i-1,j);//左
        if(j>0&&grid[i][j-1]=='1')dfs(grid,i,j-1);//上
        if(j+1<grid[0].length&&grid[i][j+1]=='1')dfs(grid,i,j+1);//右
        if(i+1<grid.length&&grid[i+1][j]=='1')dfs(grid,i+1,j);//下
    }
}
