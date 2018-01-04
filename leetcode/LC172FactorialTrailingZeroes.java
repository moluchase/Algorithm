/**
 * @author pengsong
 * @date 17/12/15 上午9:42
 */
/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */
public class LC172FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res=0;
        int temp=1;
        while (n>0){
            String s=String.valueOf(n);
            int i=s.length()-1;
            while (i>=0&&s.charAt(i)=='0'){
                i--;
                res++;
            }
            temp*=s.charAt(i)-'0';
            if(temp%10==0){temp/=10;res++;}
            temp=temp%10;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }
}
