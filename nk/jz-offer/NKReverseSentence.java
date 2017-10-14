import java.util.Stack;

public class NKReverseSentence {
    public static String ReverseSentence(String str) {
        /*
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.add(str.charAt(i));
        }
        str="";
        while (!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
        */
        String res=" ";
        if(str.trim().isEmpty())return res;
        StringBuffer stringBuffer=new StringBuffer(str);
        str=stringBuffer.reverse().toString();
        res="";
        for(String s:str.split(" ")){
            res+=new StringBuffer(s).reverse().toString()+" ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println("dd"+ReverseSentence("  ")+"dd");
    }
}
