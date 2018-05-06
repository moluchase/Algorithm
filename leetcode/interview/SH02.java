package interview;

import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/14 下午4:45
 */
public class SH02 {

    public static int getTheSum(int[][]arr){
        int sum=0;
        int start=Integer.MAX_VALUE,end=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==2){
                if(arr[i][1]<start)start=arr[i][1];
                else if(arr[i][1]>end)end=arr[i][1];
            }else {
                if(arr[i][1]<start)start=arr[i][1];
                if(arr[i][2]>end)end=arr[i][2];
            }
        }
        if(end<=start)return 0;
        int[]res=new int [end-start+1];
        for(int i=0;i<arr.length;i++){
            if(arr[i][0]==2){
                res[arr[i][1]-start]+=arr[i][2];
            }else {
                for(int j=arr[i][1];j<=arr[i][2];j++){
                    if(res[j-start]<0){
                        if(res[j-start]<arr[i][3]){
                            res[j-start]=arr[i][3];
                        }
                    }else if(res[j-start]==0)res[j-start]=arr[i][3];
                    else{
                        if(arr[i][3]>0)res[j-start]+=arr[i][3];
                    }

                }
            }
        }
        for(int i=0;i<res.length;i++){
            sum+=res[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][]arr=new int[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=scanner.nextInt();
            int length=4;
            if(arr[i][0]==2)length=3;
            for (int j=1;j<length;j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        System.out.println(getTheSum(arr));
    }
}
