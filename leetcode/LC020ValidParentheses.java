import java.util.Stack;

/**
 * @author pengsong
 * @date 18/3/10 下午10:20
 */
public class LC020ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='[')stack.push(c);
            else{
                char t=stack.pop();
                System.out.println(t);
                if(!((t=='{'&&c=='}')||(t=='['&&c==']')||(t=='('&&c==')')))return false;
                System.out.println(t+"dsdsdsd");
            }
        }
        System.out.println(stack.isEmpty());
        if(stack.isEmpty())return true;
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isValid("{}[]"));
        String s="sdsds";
    }
}
