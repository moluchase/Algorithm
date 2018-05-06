/**
 * @author pengsong
 * @date 18/1/5 上午8:21
 */
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
/*
这里定义一个数据集，定义三个指针，分别乘以三个常数依次在这个数据集上扩张数据集，选取最小的，然后让最小的指针++
 */
public class LC264UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] res=new int[n];
        res[0]=1;
        int n1,n2,n3;
        n1=n2=n3=0;
        for(int i=1;i<n;i++){
            res[i]=Math.min(2*res[n1],Math.min(3*res[n2],5*res[n3]));
            if(res[i]==2*res[n1])n1++;
            if(res[i]==3*res[n2])n2++;
            if(res[i]==5*res[n3])n3++;
        }
        return res[n-1];
    }

}
