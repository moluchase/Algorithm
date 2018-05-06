package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/31 下午7:57
 */

/*
茉莉有一个画板，画板可以抽象成100行，每行100个像素点的正方形，茉莉在画板上画画，
她一共画了n次，每次将一个矩形涂上颜色，茉莉想知道一共有多少个像素点被她涂过颜色，
若一个像素点被涂了k次，那么认为有k个像素点被涂过颜色
 */
public class QH36001 {
    //直接计算矩形的面积相加就可以了
    public static void getNumber(List<List<Integer>> lists){
        int i=0;
        int res=0;
        while (i<lists.size()){
            for(int j=0;j<lists.get(i).size();j+=4){
                res+=(lists.get(i).get(j+2)-lists.get(i).get(j+0)+1)*(lists.get(i).get(j+3)-lists.get(i).get(j+1)+1);
            }
            i++;
            System.out.println(res);
            res=0;
        }
    }
    /*
    输入
    第一行一个数 T
    对于每组数据，第一行一个整数n
    接下来n行，每行4个整数x1，y1，x2，y2

    输出
    对于每组数据，输出一行，表示茉莉一共涂了多少个像素点
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t;
        t=scanner.nextInt();
        int []n=new int[t];
        List<List<Integer>> lists=new ArrayList<>();
        for(int i=0;i<t;i++){
            n[i]=scanner.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<n[i];j++){
                list.add(scanner.nextInt());
                list.add(scanner.nextInt());
                list.add(scanner.nextInt());
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }
        scanner.close();
        getNumber(lists);
        //System.out.println();
    }
}
