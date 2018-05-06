package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/25 下午11:27
 */
public class TouTiao05 {
    static int maxHeight=0;
    public static void getMaxHeight(int[]a,int curHeight,int k,int h){
        if(maxHeight<curHeight)maxHeight=curHeight;
        if(k==0)return;
        for(int i=0;i<a.length;i++){
            if(Math.abs(curHeight-a[i])<=h){
                int value=a[i]-curHeight;
                getMaxHeight(a,curHeight+2*value>0?curHeight+2*value:0,k-1,h);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,k,h;
        n=scanner.nextInt();
        k=scanner.nextInt();
        h=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(a);
        getMaxHeight(a,0,k,h);
        System.out.println(maxHeight);
    }
}
