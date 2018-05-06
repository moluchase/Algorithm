package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/15 上午10:26
 */
public class TouTiao22 {

    static int species=0;

    public static void dfs(int[]n1,int[]n2,int i,int j,int cur,int target){
        if(cur==target)species++;
        else if(cur<target){
            if(i<n1.length){
                cur+=n1[i];
                dfs(n1,n2,i,j+1,cur,target);
                if(j<n2.length){
                    cur+=n2[j];
                    dfs(n1,n2,i,j+1,cur,target);
                    cur-=n1[i];
                    dfs(n1,n2,i+1,j+1,cur,target);
                    cur+=n1[i];
                    cur-=n2[j];
                }
                cur-=n1[i];
                dfs(n1,n2,i+1,j+1,cur,target);
            }
        }
    }

    public static void theSpecies(int[]n1,int[]n2,int target){
        Arrays.sort(n1);
        Arrays.sort(n2);
        ArrayList<Integer>n2List=new ArrayList<>();
        for(int i=0;i<n2.length;i++)n2List.add(n2[i]);
        dfs(n1,n2,0,0,0,target);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n1,n2,m;
        n1=scanner.nextInt();
        n2=scanner.nextInt();
        m=scanner.nextInt();
        int []n1Arr=new int[n1];
        int[]n2Arr=new int[n2];
        for(int i=0;i<n1;i++)n1Arr[i]=scanner.nextInt();
        for(int i=0;i<n2;i++)n2Arr[i]=scanner.nextInt();
        theSpecies(n1Arr,n2Arr,m);
        System.out.println(species);
    }
}
