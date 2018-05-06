package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/25 下午9:52
 */
/*
给定一个包含n个整数元素的集合a，一个包含m个整数元素的集合b
定义magic操作为，从一个集合中取出一个元素，放到另一个集合中，且操作过后每个集合的平均值都大于操作前
注意一下两点：
1.不可以把一个集合的元素取空，这样就没有平均值了
2.值为x的元素从集合b取出放到集合a，但集合a中已经有值为x的元素，则a的平均值不变（因为集合元素不会重复），b的平均值可能会改变（因为x被取出了）
问最多可以进行多少次magic操作？
 */
public class TouTiao04 {
    /*
    dfs
    b中取的元素应该是小于b数组的均值，且大于a数组的均值，而且不能在a数组中包含该元素
     */
    static int maxMagic=0;
    public static void getMaxMagic(ArrayList<Integer>a,ArrayList<Integer>b,float avea,float aveb,int magicStep){
        if(magicStep>maxMagic)maxMagic=magicStep;
        Collections.sort(a);
        Collections.sort(b);
        int i=b.size()-1;
        while (i>=0&&(float)b.get(i)>aveb)i--;
        while (i>=0&&(float)b.get(i)>avea){
            if(a.contains(b.get(i))){
                i--;
                continue;
            }
            int num=b.get(i);
            a.add(num);
            b.remove(i);
            getMaxMagic(a,b,(avea*(a.size()-1)+num)/a.size(),(aveb*(b.size()+1)-num)/b.size(),magicStep+1);
            b.add(i,num);
            a.remove(new Integer(num));//这里是删除num值，而不是最后一个元素，因为a被打乱了
            i--;
        }

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        n=scanner.nextInt();
        m=scanner.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        float avea=0,aveb=0;
        for(int i=0;i<n;i++){
            int num=scanner.nextInt();
            a.add(num);
            avea+=num;
        }
        for(int i=0;i<m;i++){
            int num=scanner.nextInt();
            b.add(num);
            aveb+=num;
        }
        scanner.close();
        getMaxMagic(a,b,avea/n,aveb/m,0);
        System.out.println(maxMagic);
    }
}
