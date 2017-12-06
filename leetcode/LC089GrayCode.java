import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/11/4 下午4:56
 */

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */

/*
这个题目使用dfs做
对于n位，第n位可以去0，或者取1，当第n位取0后，对第n-1位又回到了原先的子问题
函数为grayCode

然后发现题目看错了，是雷格码，然而并不知道怎么用dfs解决，只能找规律了，结果用一个n*n的二维数组来记录吧，时间复杂度为O(n^2)
这个解法函数为grayCode2
 */
public class LC089GrayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<>();
        dfs(list,n,0,0);
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+",");
        }
        return list;
    }

    private static void dfs(List<Integer> list, int n,int k,int sum) {
        if(n==0)list.add(sum);
        else {
            dfs(list,n-1,k+1,sum);
            dfs(list,n-1,k+1,sum+(int)(Math.pow(2,k)));
        }
    }
    //这个方法我发现空间复杂度消耗太大，而且时间复杂度也不低；这里只是将雷格码输出了
    public static List<Integer> grayCode2(int n) {
        List<Integer> list=new ArrayList<>();
        int m=(int)Math.pow(2,n);
        boolean[][] grayArr=new boolean[m][n];
        int k=2;
        for(int j=n-1;j>=0;j--){
            k*=2;
            for(int i=0;i<m;i++){
                if(i%k>=k/4&&i%k<k/4+k/2)grayArr[i][j]=true;
                else grayArr[i][j]=false;
            }
        }
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print((grayArr[i][j]==true?1:0)+",");
            }
            System.out.println();
        }
        return list;
    }

    //下面是一种非常简单的方法，具体见百度百科
    //这里用到的时二进制转雷格码，其中二进制代表的是雷格码的位置标号，
    // 而要求的是雷格码对应的值，所以不需要知道雷格码的形式，即省略了中间的过程
    public static List<Integer> grayCode3(int n) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<1<<n;i++){
            list.add(i^i>>1);
        }
        return list;
    }

    public static void main(String[] args) {
        //grayCode(2);
        grayCode2(4);
    }
}
