/**
 * @author pengsong
 * @date 18/1/19 上午9:05
 */
/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
 */
/*
discuss的一般解法：使用位运算，时间复杂度是O(n^2)
 */
public class LC318MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if(words==null||words.length==0)return 0;
        int[]values=new int[words.length];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++)values[i]|=1<<(words[i].charAt(j)-'a');
        }
        int maxLength=0;
        for(int i=0;i<values.length;i++){
            for (int j=i+1;j<values.length;j++){
                if((values[i]&values[j])==0){
                    int temp=words[i].length()*words[j].length();
                    if(temp>maxLength)maxLength=temp;
                }
            }
        }
        return maxLength;
    }
}
