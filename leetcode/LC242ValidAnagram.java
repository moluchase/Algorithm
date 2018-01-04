/**
 * @author pengsong
 * @date 18/1/4 上午8:58
 */
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
 */
public class LC242ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] alphs=new int[26];
        int[] alpht=new int[26];
        for(int i=0;i<s.length()||i<t.length();i++){
            if(i<s.length())alphs[s.charAt(i)-'a']++;
            if(i<t.length())alpht[t.charAt(i)-'a']++;
        }
        for(int i=0;i<alphs.length;i++){
            if(alphs[i]!=alpht[i])return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ab","a"));
    }
}
