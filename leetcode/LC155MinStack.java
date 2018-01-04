import java.util.Stack;

/**
 * @author pengsong
 * @date 17/12/13 上午8:05
 */
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

/*
用两个栈，一个将全部元素入栈，一个将当前的最小值入栈,注意一些条件
虽然很简单，但是我觉得这种题还是有意义的，和前面的一道很像，一起总结一下
 */
public class LC155MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** initialize your data structure here. */
    public LC155MinStack() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }
    //这里有重复的元素出现，需要加上>=，比如0，1，0
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||stack2.peek()>=x)stack2.push(x);
    }

    public void pop() {
        if(stack1.isEmpty())return;
        int temp=stack1.pop();
        if(temp==stack2.peek())stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
