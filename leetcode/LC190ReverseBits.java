import java.math.BigInteger;

/**
 * @author pengsong
 * @date 17/12/20 上午9:23
 */
/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).
 */
/*
无符号的右移
 */
public class LC190ReverseBits {
    public static int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res+=n&1;
            n>>>=1;
            if(i<31)res<<=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
