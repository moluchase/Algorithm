import java.util.ArrayList;
import java.util.List;

/**
 * @author pengsong
 * @date 17/12/8 上午9:14
 */
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):
The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
/*
字符串和子串的问题一定要想到dp啊
参考：https://discuss.leetcode.com/topic/6156/java-implementation-using-dp-in-two-ways
 */
public class LC139WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;//初始化
        for(int i=1;i<=s.length();i++){
            for(String word:wordDict){
                if(word.length()<=i){
                    if(dp[i-word.length()]){
                        if(word.equals(s.substring(i-word.length(),i))){
                            dp[i]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        arr.add("a");
        wordBreak("a",arr);
    }
}
