package interview;

import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/15 上午11:24
 */
public class TouTiao23 {

    public static int theStep(int[]arr,String s){
        int res=0;
        int m=arr[0],n=arr[1];
        return res;
    }

    public static void theStep(int[][]arr,String s){
        for(int i=0;i<arr.length;i++){
            System.out.println(theStep(arr[i],s));
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        int q=scanner.nextInt();
        int[][]arr=new int[q][4];
        for(int i=0;i<q;i++){
            for(int j=0;j<4;j++)arr[i][j]=scanner.nextInt();
        }
        theStep(arr,s);
    }
}
