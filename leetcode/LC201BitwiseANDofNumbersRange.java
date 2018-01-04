/**
 * @author pengsong
 * @date 17/12/21 上午9:04
 */
/*
Given a range [m, n] where 0 <= m <= n <= 2147483647,
return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
 */
/*
连续的数也就是说在不同的位上一定会有一个从0到1的过程，到没有这个过程就说明这些连续的数在该部分是相同的
 */
public class LC201BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
