package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/24 下午7:05
 */
/*
在n个元素的数组中，找到差值为k的数字对去重后的个数

输入描述：

第一行，n和k，n表示数字个数，k表示差值
第二行，n个正整数

输出描述：
差值为k的数字对去重后的个数
示例1
输入
5 2
1 5 3 4 2

输出
3

示例2
输入
6 2
1 5 3 3 4 2

输出
3
 */
public class TouTiao01 {

    /*
    使用map来存储数组中的值出现的个数
    比较当前元素加上k后的值是否在map中，如果在，就让改值对应的value减1
    k=0需要特殊考虑
     */
    public static int getTheNumber(int[]arr,int k){
        int res=0;
        if(k==0){
            for(int i=0;i<arr.length-1;i+=2){
                if(arr[i]==arr[i+1])res++;
            }
            return arr.length-res;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))map.replace(arr[i],map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])>0&&map.containsKey(arr[i]+k)&&map.get(arr[i]+k)>0){
                map.replace(arr[i]+k,map.get(arr[i])-1);
            }
        }
        for(Integer key:map.keySet()){
            res+=map.get(key);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,k;
        n=scanner.nextInt();
        k=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(arr);
        System.out.println(getTheNumber(arr,k));
    }
}
