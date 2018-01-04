import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 17/12/22 上午8:33
 */
/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.
For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
 */
/*
TLE
 */
public class LC205IsomorphicStrings {
    /*
    好吧，就用固定地址了
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        int k=0;
        String temp1,temp2;
        temp1=temp2="";
        for(int i=0;i<s.length();i++){
            if(!map1.containsKey(s.charAt(i))){
                map1.put(s.charAt(i),k);
                temp1+=k;
                if(map2.containsKey(t.charAt(i)))return false;
                map2.put(t.charAt(i),k);
                temp2+=k;
                k++;
            }else {
                if(!map2.containsKey(t.charAt(i)))return false;
                temp1+=map1.get(s.charAt(i));
                temp2+=map2.get(t.charAt(i));
            }
        }
        return temp1.equals(temp2);
    }
    //这道题中的i是为了标识位置，可以判断交叉的情况，ab，ba
    public static boolean isIsomorphic2(String s, String t) {
        int[]arr1=new int[256];
        int[]arr2=new int[256];
        for(int i=0;i<s.length();i++){
            char c1,c2;
            c1=s.charAt(i);
            c2=t.charAt(i);
            if(arr1[c1]!=arr2[c2])return false;
            arr1[c1]+=i+1;
            arr2[c2]+=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic2("egg","add"));
    }
}
