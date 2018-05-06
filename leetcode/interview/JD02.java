package interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/9 下午7:53
 */
public class JD02 {

    public static boolean isZhiShu(int i){
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0)return false;
        }
        return true;
    }

    public static int theMinNum(int n){
        BigInteger res=BigInteger.ONE;
        for(int i=2;i<=n;i++){
            int temp=1;
            if(isZhiShu(i)){
                while (temp*i<=n)temp*=i;
            }
            res=res.multiply(BigInteger.valueOf(temp));
        }
        return res.mod(BigInteger.valueOf(987654321)).intValue();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        n=scanner.nextInt();
        System.out.println(theMinNum(n));
    }
}
