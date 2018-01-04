import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/12/8 上午9:39
 */
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
add spaces in s to construct a sentence where each word is a valid dictionary word.
You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 Please reload the code definition to get the latest changes.
 */
/*
感觉想都不用想，使用dfs肯定超时
 */
public class LC140WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        dfs(s,0,wordDict,"",list);
        return list;
    }

    private static void dfs(String s, int i, List<String> wordDict, String temp,List<String> list) {
        if(i==s.length()){
            list.add(temp.trim());
        }else {
            for(String word:wordDict){
                if(word.length()<=s.length()-i){
                    if(word.equals(s.substring(i,i+word.length()))){
                        dfs(s,i+word.length(),wordDict,temp+" "+word,list);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        //["cat", "cats", "and", "sand", "dog"]
        arr.add("cat");
        arr.add("cats");
        arr.add("and");
        arr.add("sand");
        arr.add("dog");
        wordBreak("catsanddog",arr);
    }
}
