package interview;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/15 上午10:02
 */
public class TouTiao21 {

    public static boolean isSatisfy(ArrayList<Integer>arr,int num){
        int a1=arr.get(0);
        int an=arr.get(arr.size()-1);
        for(int i=0;i<arr.size();i++){
            int temp=arr.get(i);
            if(temp+num<=an){
                if(arr.indexOf(temp+num)<0)return false;
            }
            if(temp-num>=a1){
                if(arr.indexOf(temp-num)<0)return false;
            }
        }
        return true;
    }

    public static int theMinCycle(ArrayList<Integer> arr){
        int res=1;
        while (!isSatisfy(arr,res))res++;
        return res;
    }

    public static void getTheMinCycle(ArrayList<Integer>[]arr,int n){
        for(int i=0;i<n;i++){
            System.out.println(theMinCycle(arr[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[]num=new int[n];
        ArrayList<Integer>[]arr=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            num[i]=scanner.nextInt();
            for(int j=0;j<num[i];j++)arr[i].add(scanner.nextInt());
        }
        getTheMinCycle(arr,n);
    }
}
