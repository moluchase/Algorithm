import java.util.Stack;

/**
 * @author pengsong
 * @date 18/3/11 下午1:19
 */
public class LC032LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int[] noMemo=new int[s.length()+2];
        noMemo[0]=-1;
        int k=1;
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
                noMemo[k++]=i;
            }else{
                if(!stack.isEmpty()){
                    char t=stack.pop();
                    if(t=='('){
                        k=k-1;
                    }else{
                        stack.push(t);
                        stack.push(c);
                        noMemo[k++]=i;
                    }
                }else{
                   stack.push(c);
                   noMemo[k++]=i;
                }
            }
        }
        noMemo[k]=s.length();
        int res=0;
        for(int i=1;i<=k;i++){
            //System.out.println(noMemo[i]);
            int temp=noMemo[i]-noMemo[i-1]-1;
            if(temp>res)res=temp;
        }
        return res;
    }


    public static int longestValidParentheses2(String s) {
        int[]dp=new int[s.length()+1];
        int res=0;
        for(int i=1;i<=s.length();i++){
            for(int j=i;j>0&&s.charAt(j-1)==')'&&j-dp[j-1]-2>=0&&s.charAt(j-dp[j-1]-2)=='(';j=j-dp[j-1]-2){
                dp[i]+=dp[j-1]+2;
            }
            if(res<dp[i])res=dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("()"));
        int [] res=new int[]{2,3};
    }
}
