/**
 * @author pengsong
 * @date 17/12/15 上午8:26
 */
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.
 */

/*
进制转换问题
要考虑26的情况，26为Z，52为AZ，
 */
public class LC168ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String res="";
        return getColumn(res,n);
    }

    private static String getColumn(String res, int n) {
        if(n==0)return res;
        if(n%26==0){res='Z'+res;n=n/26-1;}
        else {res=(char)('A'+n%26-1)+res;n=n/26;}
        res=getColumn(res,n);
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(String.valueOf((char)('A'+2)));
        System.out.println(convertToTitle(52));
    }
}
