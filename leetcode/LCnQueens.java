import java.util.ArrayList;
import java.util.List;

public class LCnQueens {
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] flag=new boolean[n][n];//标志矩阵
        boolean[][] queen=new boolean[n][n];//皇后矩阵
        List<List<String>> lists=new ArrayList<>();
        return queenDfs(queen,flag,lists,0);
    }

    private static List<List<String>> queenDfs(boolean[][] queen, boolean[][] flag, List<List<String>> lists, int index) {
        //遍历到头
        if(index==queen.length){
            List<String> list=new ArrayList<>();
            for(int i=0;i<queen.length;i++){
                String s="";
                for(int j=0;j<queen.length;j++){
                    if(queen[i][j]==true)s+="Q";
                    else s+=".";
                }
                list.add(s);
            }
            lists.add(list);
            return lists;
        }
        //dfs,遍历第index行
        for(int j=0;j<queen.length;j++){
            if(flag[index][j]==true)continue;
            else queen[index][j]=true;
            //临时矩阵
            boolean [][] temp=new boolean[queen.length][queen.length];
            for(int k=0;k<queen.length;k++){
                for(int p=0;p<queen.length;p++){
                    temp[k][p]=flag[k][p];
                }
            }
            //处理标志矩阵
            for(int k=0;k<queen.length;k++)flag[index][k]=true;//横
            for(int k=0;k<queen.length;k++)flag[k][j]=true;//竖
            for(int k=0;j+k<queen.length&&index+k<queen.length;k++)flag[index+k][j+k]=true;//东南
            for(int k=1;j-k>=0&&index-k>=0;k++)flag[index-k][j-k]=true;//西北
            for(int k=1;index-k>=0&&j+k<queen.length;k++)flag[index-k][j+k]=true;//东北
            for (int k=0;index+k<queen.length&&j-k>=0;k++)flag[index+k][j-k]=true;//西南
            lists=queenDfs(queen,flag,lists,index+1);
            //回溯
            queen[index][j]=false;
            for(int k=0;k<queen.length;k++){
                for(int p=0;p<queen.length;p++){
                    flag[k][p]=temp[k][p];
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<String>> lists=solveNQueens(4);
        for(int i=0;i<lists.size();i++){
            for (int j=0;j<lists.get(0).size();j++){
                System.out.println(lists.get(i).get(j));
            }
            System.out.println();
        }
    }
}
