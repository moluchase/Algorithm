import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 17/12/14 上午8:34
 */
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Credits:
Special thanks to @Shangrila for adding this problem and creating all test cases.
 */
/*
String 字符串常量
StringBuffer 字符串变量（线程安全）
StringBuilder 字符串变量（非线程安全）比StringBuffer快
 */

/*
这道题考虑的情况有点多额。。。
 */
public class LC166FractiontoRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res=new StringBuilder("");
        Map<Long,Integer> map=new HashMap<>();

        res.append(((numerator >=0) ^ (denominator >=0)) ? "-" : "");
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);

        res.append(String.valueOf(num/den));
        num=num%den;
        if(num==0)return res.toString().equals("-0")?"0":res.toString();
        res.append(".");
        while (num!=0){
            map.put(num,res.length());
            num=num*10;
            res.append(String.valueOf(num/den));
            num=num%den;
            if(map.containsKey(num)){
                res.insert((int)(map.get(num)),'(');
                res.append(')');
                break;
            }
        }
        //System.out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        fractionToDecimal(0,-5);
    }
}
