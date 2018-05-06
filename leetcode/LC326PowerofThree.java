import java.math.BigDecimal;

/**
 * @author pengsong
 * @date 18/1/24 上午8:58
 */
/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
 */
/*
这道题的规律还是比较好找的。。。
19146/21038
 */
public class LC326PowerofThree {
    public boolean isPowerOfThree(int n) {
        if(n%10==1){
            if(n==1)return true;
            else if(n%3==0&&(n/3)%10==7){
                n=n/3;
                if(n%3==0&&(n/3)%10==9)return false;
            }
            return false;
        }else if(n%10==3){
            if(n==3)return true;
            return n/3%3==0&&(n/3)%10==1;
        }
        else if(n%10==9)return n/3%3==0&&(n/3)%10==3;
        else if(n%10==7)return n/3%3==0&&(n/3)%10==9;
        else return false;
    }
    //也不可以...,21033/21038
    public static boolean isPowerOfThree2(int n) {
        System.out.println(new BigDecimal(Math.log(n)/Math.log(3)).floatValue());
        return (Math.log(n)/Math.log(3))%1==0;
        //return ( n>0 &&  1162261467%n==0);//这句通过了。。。
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(243));
    }

}
