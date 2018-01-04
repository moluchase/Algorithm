import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/12/21 上午9:25
 */
/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
/*
这都能通过，最简单最暴力的解法都能够通过
 */
public class LC202HappyNumber {
    public static boolean isHappy(int n) {
        List<Integer> list=new ArrayList<>();
        return isHappy(n,list);
    }

    private static boolean isHappy(int n, List<Integer> list) {
        if(n==1)return true;
        if(list.contains(n))return false;
        list.add(n);
        char[] chars=String.valueOf(n).toCharArray();
        int temp=0;
        for(int i=0;i<chars.length;i++){
            int num=chars[i]-'0';
            temp+=num*num;
        }
        //System.out.println(temp);
        return isHappy(temp,list);
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
