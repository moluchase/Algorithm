/**
 * @author pengsong
 * @date 18/1/4 上午10:06
 */
/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */
/*
这道题要求O(1)的解法，用的是数字根
dr(n)=1+((n-1)mod 9)
 */
public class LC258AddDigits {
    public static int addDigits(int num) {
        while (String.valueOf(num).length()>1){
            char[] nums=String.valueOf(num).toCharArray();
            num=0;
            for(int i=0;i<nums.length;i++) num+=nums[i]-'0';
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
