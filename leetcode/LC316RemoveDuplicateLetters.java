/**
 * @author pengsong
 * @date 18/1/18 上午10:30
 */
/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
 */
//discuss中第一和第二的解法其实是一样的，一个递归，一个for
public class LC316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s==null||s.length()==0)return "";
        int[] count=new int[26];
        int pos=0;
        for(int i=0;i<s.length();i++)count[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<s.charAt(pos))pos=i;
            if(--count[s.charAt(i)-'a']==0)break;
        }
        return s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replace(""+s.charAt(pos),""));
    }
}
