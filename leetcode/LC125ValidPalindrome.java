/**
 * @author pengsong
 * @date 17/11/25 上午8:48
 */

/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

/*
排除 字母，数字之外的其它字符
 */
public class LC125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null||s.length()<2)return true;
        int i,j;
        i=0;
        j=s.length()-1;
        while (i<j){
            char c=s.charAt(i);
            char c2=s.charAt(j);
            while (!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                i++;
                if(i>j)return true;
                else c=s.charAt(i);
            }
            while (!((c2>='a'&&c2<='z')||(c2>='A'&&c2<='Z')||(c2>='0'&&c2<='9'))){
                j--;
                if(j<i)return true;
                else c2=s.charAt(j);
            }
            if(Character.toUpperCase(c)==Character.toUpperCase(c2)){
                i++;
                j--;
            }else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Character.toUpperCase('a')==Character.toUpperCase('A'));
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isUpperCase('a')==Character.isUpperCase('A'));
    }
}
