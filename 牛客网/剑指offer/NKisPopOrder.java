import java.util.Stack;

public class NKisPopOrder {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int temp;
        int i,j;
        i=j=0;
        while (i<pushA.length){
            if(pushA[i]==popA[j]){
                i++;
                j++;
            }else {
                if(!stack.isEmpty()){
                    temp=stack.pop();
                    if(temp==popA[j]){
                        j++;
                    }else {
                        stack.push(temp);
                        stack.push(pushA[i]);
                        i++;
                    }
                }else {
                    stack.push(pushA[i]);
                    i++;
                }
            }

        }
        while (!stack.isEmpty()){
            temp=stack.pop();
            if(temp!=popA[j]){
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{},new int[]{}));
    }

}
