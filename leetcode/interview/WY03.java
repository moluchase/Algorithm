package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/27 下午8:31
 */
public class WY03 {

    public static long getMaxPay(int[]di,Map<Integer,Integer> map,int ai){
        int res=0;
        int i=0;
        while (i<di.length&&ai>=di[i]){
            int value=map.get(di[i]);
            if(value>res)res=value;
            i++;
        }
        return res;
    }

    public static void printMaxPay(int[]di,int[]pi,int[]ai){
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        for(int i=0;i<di.length;i++){
            map.put(di[i],pi[i]);
            map.put(pi[i],di[i]);
        }
        Arrays.sort(di);
        for(int i=0;i<ai.length;i++){
            System.out.println(getMaxPay(di,map,ai[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        n=scanner.nextInt();
        m=scanner.nextInt();
        int[]di=new int[n];
        int[]pi=new int[n];
        int[]ai=new int[m];
        for(int i=0;i<n;i++){
            di[i]=scanner.nextInt();
            pi[i]=scanner.nextInt();
        }
        for(int i=0;i<m;i++){
            ai[i]=scanner.nextInt();
        }
        scanner.close();
        printMaxPay(di,pi,ai);
    }
}
