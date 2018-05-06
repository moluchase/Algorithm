package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/14 下午4:29
 */
public class SH01 {

    public static int partition(int[] arr, int left, int right) {
        int result = arr[left];
        if (left > right)
            return -1;

        while (left < right) {
            while (left < right && arr[right] >= result) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = result;
        return left;
    }
    public static int[] getLeastNumbers(int[] input,int k){
        if(input.length == 0 || k<= 0)
            return null;
        int[] output = new int[k];
        int start = 0;
        int end = input.length-1;
        int index = partition(input,start,end);
        while(index != k-1){
            if(index > k-1){
                end = index -1;
                index = partition(input,start ,end);
            }
            else{
                start = index+1;
                index = partition(input,start ,end);
            }
        }
        for(int i = 0;i<k;i++){
            output[i] = input[i];
        }
        return output;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n,k;
        n=scanner.nextInt();
        k=scanner.nextInt();
        int []arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        arr=getLeastNumbers(arr,k);
        int []res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        Arrays.sort(res);
        for(int i = 0;i<res.length-1;i++){
            System.out.print(res[i]+",");
        }
        System.out.println(res[res.length-1]);
    }
}
