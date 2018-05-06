package interview;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/31 下午8:24
 */
/*
茉莉邀请她的朋友参加周末的派对，茉莉买了3种颜色的气球，现在她要用这些气球来装饰餐桌，
每个餐桌只用恰好3个气球装饰，要求3个气球的颜色不能完全一样，可以是2种或者3种，
茉莉想知道这些气球最多能装饰多少张餐桌
 */
public class QH36002 {
    /*
    在选两种颜色中最大装饰餐桌数量的时候，同样选取最小的，也就是最多只能装饰最小的个数的数量
    而且要满足最小的个数乘以3小于等于总的气球个数
     */
    public static int getNum(int i,int j){
        int res=Math.min(i,j);
        while (res*3>i+j)res--;
        return res;
    }

    /*
    我的想法是，先选3种颜色的情况，然后再选2种情况的颜色，将其相加作为最大的装饰餐桌数
     */
    public static int theMaxNumber(int r,int g,int b){
        int res=0;
        int min=Math.min(Math.min(r,g),b);
        res+=min;
        r-=min;
        g-=min;
        b-=min;
        if(r==0)res+=getNum(g,b);
        else if(g==0)res+=getNum(r,b);
        else res+=getNum(r,g);
        return res;
    }

    public static void getMax(int[][]rgb){
        for(int i=0;i<rgb.length;i++){
            System.out.println(theMaxNumber(rgb[i][0],rgb[i][1],rgb[i][2]));
        }
    }
    /*
    输入
    第一行一个数T，表示数据数组
    对于每组数据，第一行3个整数，r，g，b分别表示三种颜色的气球个数
    输出
    对于每组数组，输出一行，一个整数表示最多能够装饰的餐桌数
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t;
        t=scanner.nextInt();
        int [][]rgb=new int[t][3];
        for(int i=0;i<t;i++){
            rgb[i][0]=scanner.nextInt();
            rgb[i][1]=scanner.nextInt();
            rgb[i][2]=scanner.nextInt();
        }
        scanner.close();
        getMax(rgb);
    }
}
