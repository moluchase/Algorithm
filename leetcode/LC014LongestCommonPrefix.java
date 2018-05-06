import java.util.Stack;

/**
 * @author pengsong
 * @date 18/3/10 下午8:34
 */
public class LC014LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String temp=strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<temp.length())temp=strs[i];
        }
        if(temp==null||temp.length()==0)return "";
        int i=0;
        while(i<strs.length){
            int len=temp.length();
            if(!(strs[i].substring(0,len).equals(temp))){
                i=0;
                temp=temp.substring(0,len-1);
            }else i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"aa","abc"});
        Stack<Character> stack=new Stack<>();
    }
}
