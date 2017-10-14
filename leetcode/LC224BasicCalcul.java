import java.util.ArrayList;
import java.util.Stack;

public class LC224BasicCalcul {

    /**
     * 有两种方法解决这个问题
     * 一种方法【calculate2】是将表达式转为后缀表达式，再求值；这是最经典的方法
     * 另外一种方法【calculate1】局限于加减法，正好适合此题
     *
     */


    public static int calculate1(String s) {
        Stack<Character> stack=new Stack<>();
        Stack<Integer> stack1=new Stack<>();
        String temp="";
        String strInt;
        int i=0;
        char c,c2;
        int a1,a2;
        int flag=0;
        s=s.replace(" ","");//去除字符串中的空格
        while(i<s.length()){
            c=s.charAt(i);
            switch (c){
                case '(':
                    stack.push(c);
                    flag++;
                    break;
                case ')':
                    flag--;
                    while ((c=stack.pop())!='('){
                        temp+=c;
                    }
                    break;
                case '+':
                case '-':
                    while (flag==0&&!stack.isEmpty()){
                        c2=stack.pop();
                        temp+=c2;
                    }
                    stack.push(c);
                    break;
                default:
                    //此处用#将数字分开
                    while (i<s.length()&&c>='0'&&c<='9'){
                        temp+=c;
                        i++;
                        if(i<s.length()){
                            c=s.charAt(i);
                        }

                    }
                    /*
                    do{
                        temp+=c;
                        i++;
                    }while (i<s.length()&&(c=s.charAt(i))>='0'&&c<='9');
                    */
                    temp+='#';
                    i--;
            }
            i++;
        }
        while(!stack.isEmpty()){
            temp+=stack.pop();
        }
        //System.out.println(temp);


        //计算后缀表达式
        i=0;
        while (i<temp.length()){
            if(temp.charAt(i)>='0'&&temp.charAt(i)<='9'){
                strInt="";
                while (i<temp.length()&&temp.charAt(i)>='0'&&temp.charAt(i)<='9'){
                    strInt+=temp.charAt(i);
                    i++;
                }
                i++;//跳过#
                stack1.push(Integer.parseInt(strInt));
            }else {
                c=temp.charAt(i);
                a1=stack1.pop();
                a2=stack1.pop();
                switch (c){
                    case '+':a2=a1+a2;break;
                    case '-':a2=a2-a1;break;
                }
                stack1.push(a2);
                i++;
            }
        }
        return stack1.pop();
    }


    //判断两个字符叠加的结果
    public static char calSymbol(char c1,char c2){
        if((c1=='+'&&c2=='+')||(c1=='-'&&c2=='-')){
            return '+';
        }else {
            return '-';
        }
    }

    public static int calculate2(String s) {
        Stack<Character> stack=new Stack<>();
        String temp;//用来存储数字
        int sum=0;//求和
        char c1,c2;//c1为左括号前面符合的叠加结果，c2位要计算的数字前面的符号
        int i=0;
        c1='+';
        s=s.replace(" ","");//去除字符串中的空格
        //时间复杂度为O(n)
        while(i<s.length()){
            /**
             * 如果为'('此时需要将'('前面的符号入栈，并且计算c1，表明当前括号内的一级符号
             * 如果为')'，出栈，并与c1进行叠加
             * 如果为数字，判断数字前面的符号，赋值给c2；循环得到数字的值，最后由c1和c2判断该数字实际的符号，与sum运算
             */
            if(s.charAt(i)=='('){
                if(i==0){
                    stack.push('+');
                    c1='+';
                }else {
                    stack.push(s.charAt(i-1));
                    c1=calSymbol(c1,s.charAt(i-1));
                }
            }else if(s.charAt(i)==')'){
                c1=calSymbol(c1,stack.pop());
            }else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                //c2=s.charAt(i);
                if(i==0||(s.charAt(i-1)!='+'&&s.charAt(i-1)!='-')){
                    c2=calSymbol(c1,'+');
                }else {
                    c2=calSymbol(c1,s.charAt(i-1));
                }
                temp="";
                while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    temp+=s.charAt(i);
                    i++;
                }
                i--;//为了配合后面的
                if(c2=='-'){
                    sum-=Integer.parseInt(temp);
                }else {
                    sum+=Integer.parseInt(temp);
                }
            }
            i++;
        }
        return sum;

    }

    public static void main(String[] args) {
        //2343+-+4-49++
        System.out.println(calculate1("(2+3-(4+3))-4+(4+9)"));
        System.out.println(calculate2("(2+3-(4+3))-4+(4+9)"));
    }
}
