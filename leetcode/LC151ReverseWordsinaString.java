/**
 * @author pengsong
 * @date 17/12/12 上午8:33
 */
/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.
 */

/*
这么简单的题目，哎，还超时了，但是我这个时间复杂度是O(n)啊

 */
public class LC151ReverseWordsinaString {
    public static String reverseWords(String s) {
        String temp=reverse(s);
        String result="";
        for(String temp2:temp.split(" +")){
            result+=reverse(temp2);
        }
        return result.trim();
    }

    private static String reverse(String s) {
        s=s.trim();
        String temp="";
        for(int i=s.length()-1;i>=0;i--){
            temp+=s.charAt(i);
        }
        return temp;
    }
/*
参考：https://discuss.leetcode.com/topic/11785/java-3-line-builtin-solution
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
*/
/*
看到这个解法，顿时觉得自己是个白痴，把问题想复杂了
参考：https://leetcode.com/problems/reverse-words-in-a-string/discuss/
String[] parts = s.trim().split("\\s+");
String out = "";
for (int i = parts.length - 1; i > 0; i--) {
    out += parts[i] + " ";
}
return out + parts[0];
 */
    public static void main(String[] args) {
        //reverseWords("  a  b  ");
    }

}
/*
    public String reverseWords(String s) {
        String temp=reverse(s);
        String result="";
        for(String temp2:temp.split(" ")){
            String t=reverse(temp2);
            result+=t.length()>0?" "+t:"";
        }
        return result.trim();
    }
    private String reverse(String s) {
        s=s.trim();
        String temp="";
        for(int i=s.length()-1;i>=0;i--){
            temp+=s.charAt(i);
        }
        temp=temp.trim();
        return temp.length()!=0?temp:"";
    }
 */