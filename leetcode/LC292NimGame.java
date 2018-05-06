/**
 * @author pengsong
 * @date 18/1/7 上午10:11
 */
/*
You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones.
The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game.
Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 */
/*

 */
public class LC292NimGame {
    public static boolean canWinNim(int n) {
        boolean[]dp=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(i<4)dp[i]=true;
            else if(!dp[i-1]||!dp[i-2]||!dp[i-3])dp[i]=true;
            else dp[i]=false;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(1));
    }
}
