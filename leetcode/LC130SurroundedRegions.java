import java.util.*;

/**
 * @author pengsong
 * @date 17/11/29 下午5:26
 */

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
/*
这道题思路确实不难，直接用经典的深度优先遍历即可，只是不好写而已，所以难度为medium而不是hard
一般的深度优先遍历都要用一个flag数组来记录已经遍历过的元素，用栈来回退，这道题除此之外还需要用一个list来记录一次栈非空到空中的元素，
也就是说一次栈非空到空得过程中，是一次查找O连接的过程，如果发现O的下标到了边界，说明这部分O没有被包围，不需要翻转，那么清空list
如果这部分O被包围了，那么将这部分O翻转，而这部分O全部保存在list中
 */
public class LC130SurroundedRegions {
    public static void solve(char[][] board) {
        if(board.length<2)return;
        int n=board.length;
        int m=board[0].length;
        int r,c;
        boolean[][] flag=new boolean[n][m];
        Stack<String> stack=new Stack<>();
        List<String> list=new ArrayList<>();
        boolean isFlip=false;
        r=1;
        for(;r<n-1;r++){
            c=1;
            for(;c<m-1;c++){
                if(board[r][c]=='O'&&!flag[r][c]){
                    stack.add(""+r+"#"+c);
                }
                while (!stack.isEmpty()){
                    int i,j;
                    String temp=stack.pop();
                    i=Integer.parseInt(temp.split("#")[0]);
                    j=Integer.parseInt(temp.split("#")[1]);
                    flag[i][j]=true;
                    list.add(temp);
                    if(i==0||j==0||i==n-1||j==m-1)isFlip=true;
                    else {
                        if(board[i][j-1]=='O'&&!flag[i][j-1])stack.push(""+i+"#"+(j-1));
                        if(board[i-1][j]=='O'&&!flag[i-1][j])stack.push(""+(i-1)+"#"+j);
                        if(board[i][j+1]=='O'&&!flag[i][j+1])stack.push(""+i+"#"+(j+1));
                        if(board[i+1][j]=='O'&&!flag[i+1][j])stack.push(""+(i+1)+"#"+j);
                    }
                }
                if(isFlip==true) isFlip=false;
                else {
                    for(String s:list){
                        board[Integer.parseInt(s.split("#")[0])][Integer.parseInt(s.split("#")[1])]='X';
                    }
                }
                list.clear();
            }
        }

    }

    public static void main(String[] args) {
        solve(new char[][]{{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','X'},{'O','X','O','X'}});
    }
}
