package interview;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author pengsong
 * @date 18/4/18 下午8:51
 */
public class Baidu02 {

    public static BigInteger A(BigInteger big,int y){
        BigInteger bigInteger=BigInteger.ONE;
        for(int i=1;i<=y;i++){
            bigInteger=bigInteger.multiply(BigInteger.valueOf(i));
        }
        return big=bigInteger.multiply(big);
    }

    public static int theNum(int n){
        BigInteger bigInteger=BigInteger.ONE;
        bigInteger=bigInteger.multiply(BigInteger.valueOf(10*2*6));
        bigInteger=A(bigInteger,n);
        return bigInteger.mod(BigInteger.valueOf(1000000007)).intValue();

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(theNum(n));
    }
}
