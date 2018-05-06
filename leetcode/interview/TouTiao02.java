package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/3/24 下午8:02
 */
/*
题目描述：

定义两个字符变量：s和m，再定义两种操作，

第一种操作：

m=s；

s=s+s;

第二种操作：

s=s+m;

假设初始化如下：

s="a"; m=s;

求最小的操作步骤数，可以将s拼接到长度等于n；
 */
public class TouTiao02 {
    static int minStep=Integer.MAX_VALUE;//记录需要变换的最小次数
    /*
    这里由于第一次变换比第二次变换使得字符串增长的更快，所以先走第一次变换，
    如果无法达到，则回退
    如果达到，就和最小的步数比较

    这里应该可以用dp做的，懒得想了
     */
    public static void dfs(String s,String m,int step,int n){
        if(s.length()>=n){
            if(s.length()==n)minStep=step<minStep?step:minStep;
        }
        else {
                dfs(s+s,s,step+1,n);
                dfs(s+m,m,step+1,n);
        }
    }

    public static int getMinStep(int n){
        dfs("mm","m",1,n);
        return minStep;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        scanner.close();
        System.out.println(getMinStep(n));
    }
}
