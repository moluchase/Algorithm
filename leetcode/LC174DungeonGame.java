/**
 * @author pengsong
 * @date 17/12/16 上午9:46
 */
/*
挺有意思的一道题，先放在了
用一个二维矩阵决定选择
用一个二维矩阵来计算
dp不会，我先用dfs做,不过我就知道会超时，40/44，TLE
看了看discuss，想不到...
 */
public class LC174DungeonGame {
    public int calculateMinimumHP2(int[][] dungeon) {
        return dfs(0,0,dungeon,1,0);
    }

    private int dfs(int i, int j, int[][] dungeon, int minHealth, int currHealth) {
        if(i==dungeon.length-1&&j==dungeon[0].length-1){
            return currHealth+dungeon[i][j]+minHealth>0?minHealth:-(currHealth+dungeon[i][j])+1;
        }
        currHealth+=dungeon[i][j];
        minHealth=currHealth+minHealth>0?minHealth:-currHealth+1;
        int temp1=0,temp2=0;
        if(i<dungeon.length-1)temp1=dfs(i+1,j,dungeon,minHealth,currHealth);
        if(j<dungeon[0].length-1)temp2=dfs(i,j+1,dungeon,minHealth,currHealth);
        if(temp1!=0&&temp2!=0) return temp1>temp2?temp2:temp1;
        return temp1==0?temp2:temp1;
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int dp[][]=new int[m][n];//记录最小的能量
        int temp;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1&&j==n-1)dp[i][j]=dungeon[i][j]>0?1:1-dungeon[i][j];
                else if(i==m-1)dp[i][j]=(temp=dp[i][j+1]-dungeon[i][j])>0?temp:1;
                else if(j==n-1)dp[i][j]=(temp=dp[i+1][j]-dungeon[i][j])>0?temp:1;
                else dp[i][j]=(temp=Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j])>0?temp:1;
            }
        }
        return dp[0][0];
    }
}
