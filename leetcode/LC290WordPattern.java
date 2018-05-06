import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengsong
 * @date 18/1/7 上午9:17
 */
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space
 */
public class LC290WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        Map<String,Character> map=new HashMap<>();
        String[] charMap=new String[26];
        for(int i=0;i<charMap.length;i++)charMap[i]="";
        String[]strs=str.split(" ");
        if(pattern.length()!=strs.length)return false;
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            if(map.containsKey(strs[i])){if(!map.get(strs[i]).equals(c))return false;}
            else map.put(strs[i],c);
            if(charMap[c-'a'].equals(""))charMap[c-'a']=strs[i];
            else if(!charMap[c-'a'].equals(strs[i]))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(wordPattern("abba","dog ddd ddd dog"));
        Map<Integer,String>map=new HashMap<>();
        map.put(2,"sdsd");
        System.out.println(map.put(3,"dddd"));
        System.out.println(map.put(2,"s"));
        System.out.println(map.put(2,"s"));
    }
}
