/**
 * @author pengsong
 * @date 17/12/15 上午9:31
 */
/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */
/*
也是醉了的一道题，变来变去的，easy
 */
public class LC171ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int n=s.length();
        int res=0;
        return getNumber(n,s);
    }

    private static int getNumber(int n, String s) {
        if(n==0)return 0;
        return (int)((s.charAt(0)-'A'+1)*Math.pow(26,n-1)+getNumber(n-1,s.substring(1)));
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }
}
