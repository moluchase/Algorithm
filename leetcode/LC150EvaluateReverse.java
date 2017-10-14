import java.util.Stack;

public class LC150EvaluateReverse {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();//栈，用来存储数字
        int a,b,temp;//中间变量，做计算用
        for(int i=0;i<tokens.length;i++){
            //int c=Integer.parseInt(tokens[i]);//获取字符串，转为字符
            // 如果c为数字，则进栈,否则出栈，并计算，再将结果进栈
            if(tokens[i].matches("-?[0-9]+")){
                stack.push(Integer.parseInt(tokens[i]));
            } else{
                a=stack.pop();
                b=stack.pop();
                temp=0;
                switch (tokens[i].charAt(0)){
                    case '+': temp=b+a;break;
                    case '-': temp=b-a;break;
                    case '*': temp=b*a;break;
                    case '/': temp=b/a;break;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens={"3", "-4", "+"};
        System.out.println(evalRPN(tokens));
    }
}

