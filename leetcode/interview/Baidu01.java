package interview;

import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/18 下午8:17
 */
public class Baidu01 {

    static int maxHeight=0;
    public static void dfs(int[][]arr,int i,int j,boolean[][]flag){
        if(i-1>=0&&i<=arr.length&&j-1>=0&&j<=arr[0].length){
            if(arr[i-1][j-1]>maxHeight)maxHeight=arr[i-1][j-1];
            if(j-2>=0&&flag[i-1][j-2]==false&&arr[i-1][j-1]<=arr[i-1][j-2]){
                flag[i-1][j-2]=true;
                //if(arr[i-1][j-2]>maxHeight)maxHeight=arr[i-1][j-2];
                dfs(arr,i,j-1,flag);
                flag[i-1][j-2]=false;
            }
            if(j+1<=arr[0].length&&flag[i-1][j]==false&&arr[i-1][j-1]<=arr[i-1][j]){
                flag[i-1][j]=true;
                //if(arr[i-1][j]>maxHeight)maxHeight=arr[i-1][j];
                dfs(arr,i,j+1,flag);
                flag[i-1][j]=false;
            }
            if(i-2>=0&&flag[i-2][j-1]==false&&arr[i-1][j-1]<=arr[i-2][j-1]){
                flag[i-2][j-1]=true;
                //if(arr[i-1][j]>maxHeight)maxHeight=arr[i-1][j];
                dfs(arr,i-1,j,flag);
                flag[i-2][j-1]=false;
            }
            if(i+1<=arr.length&&flag[i][j-1]==false&&arr[i-1][j-1]<=arr[i][j-1]){
                flag[i][j-1]=true;
                //if(arr[i-1][j]>maxHeight)maxHeight=arr[i-1][j];
                dfs(arr,i+1,j,flag);
                flag[i][j-1]=false;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(),m=scanner.nextInt();
        int sx=scanner.nextInt(),sy=scanner.nextInt();
        int[][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        boolean[][]flag=new boolean[n][m];
        dfs(arr,sx,sy,flag);
        System.out.println(maxHeight);
    }
}
