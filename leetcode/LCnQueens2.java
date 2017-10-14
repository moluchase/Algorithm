import java.util.ArrayList;
import java.util.List;

public class LCnQueens2 {
    public static int totalNQueens(int n) {
        boolean[][] flag=new boolean[n][n];
        boolean[][] queen=new boolean[n][n];
        return queenDfs(queen,flag,0);
    }
    private static int queenDfs(boolean[][] queen, boolean[][] flag, int index) {
        if(index==queen.length){
            return 1;
        }
        int num=0;
        for(int j=0;j<queen.length;j++){
            if(flag[index][j]==true)continue;
            else queen[index][j]=true;
            boolean [][] temp=new boolean[queen.length][queen.length];
            for(int k=0;k<queen.length;k++){
                for(int p=0;p<queen.length;p++){
                    temp[k][p]=flag[k][p];
                }
            }
            for(int k=0;k<queen.length;k++)flag[index][k]=true;//横
            for(int k=0;k<queen.length;k++)flag[k][j]=true;//竖
            for(int k=0;j+k<queen.length&&index+k<queen.length;k++)flag[index+k][j+k]=true;//东南
            for(int k=1;j-k>=0&&index-k>=0;k++)flag[index-k][j-k]=true;//西北
            for(int k=1;index-k>=0&&j+k<queen.length;k++)flag[index-k][j+k]=true;//东北
            for (int k=0;index+k<queen.length&&j-k>=0;k++)flag[index+k][j-k]=true;//西南
            num+=queenDfs(queen,flag,index+1);
            queen[index][j]=false;
            for(int k=0;k<queen.length;k++){
                for(int p=0;p<queen.length;p++){
                    flag[k][p]=temp[k][p];
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(8));
    }
}
