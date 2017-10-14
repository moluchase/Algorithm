import java.util.Stack;

public class NKmin {
    Stack<Integer> dataStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    int temp;
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()||minStack.peek()>=node) minStack.push(node);
    }

    public void pop() {
        if(dataStack.peek()==minStack.peek())minStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
