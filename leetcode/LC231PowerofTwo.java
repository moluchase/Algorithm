/**
 * @author pengsong
 * @date 18/1/3 上午8:37
 */
/*
Given an integer, write a function to determine if it is a power of two.
 */
/*
一句话就搞定了，终于能写出这样的代码了
 */
public class LC231PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n==0?false:(n==1?true:(n%2==0?isPowerOfTwo(n/2):false));
    }
}
