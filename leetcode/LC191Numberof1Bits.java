/**
 * @author pengsong
 * @date 17/12/20 上午9:40
 */
/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class LC191Numberof1Bits {
    public static int hammingWeight(int n) {
        int num=0;
        for(int i=0;i<32;i++){
            num+=n&1;
            n>>>=1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
