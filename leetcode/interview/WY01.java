package interview;


import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/27 下午7:59
 */
public class WY01 {
    public static int getMaxNum(int[]x1,int[]x2,int[]y1,int[]y2){
        int res=1;
        int minx1=Integer.MAX_VALUE,miny1=Integer.MAX_VALUE;
        int maxx2=Integer.MIN_VALUE,maxy2=Integer.MIN_VALUE;
        for(int i=0;i<x1.length;i++){
            if(x1[i]<minx1)minx1=x1[i];
            if(x2[i]>maxx2)maxx2=x2[i];
            if(y1[i]<miny1)miny1=y1[i];
            if(y2[i]>maxy2)maxy2=y2[i];
        }
        int[][]num=new int[maxx2-minx1+1][maxy2-miny1+1];
        for(int i=minx1;i<=maxx2;i++){
            for(int j=miny1;j<=maxy2;j++){
                for(int k=0;k<x1.length;k++){
                    if(x1[k]<i&&y1[k]<j&&x2[k]>i&&y2[k]>j){
                        num[i-minx1][j-miny1]++;
                    }
                }
            }
        }
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[0].length;j++){
                if(num[i][j]>res)res=num[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        int[] x1=new int[n];
        int[] x2=new int[n];
        int[] y1=new int[n];
        int[] y2=new int[n];
        for(int i=0;i<n;i++)x1[i]=scanner.nextInt();
        for(int i=0;i<n;i++)y1[i]=scanner.nextInt();
        for(int i=0;i<n;i++)x2[i]=scanner.nextInt();
        for(int i=0;i<n;i++)y2[i]=scanner.nextInt();
        scanner.close();
        System.out.println(getMaxNum(x1,x2,y1,y2));
    }
}
