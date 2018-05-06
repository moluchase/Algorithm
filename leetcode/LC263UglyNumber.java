/**
 * @author pengsong
 * @date 18/1/5 上午8:14
 */
/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class LC263UglyNumber {
    public boolean isUgly(int num) {
        return num==0?false:num%5==0?isUgly(num/5):num%3==0?isUgly(num/3):num%2==0?isUgly(num/2):num==1?true:false;
    }
}
