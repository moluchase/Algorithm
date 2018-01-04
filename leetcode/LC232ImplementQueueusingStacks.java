import java.util.Stack;

/**
 * @author pengsong
 * @date 18/1/3 上午8:49
 */
/*
mplement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class LC232ImplementQueueusingStacks {
    Stack<Integer> stack1,stack2;
    /** Initialize your data structure here. */
    public LC232ImplementQueueusingStacks() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int temp=0;
        while (!stack1.isEmpty()){
            temp=stack1.pop();
            if(!stack1.isEmpty())stack2.push(temp);
        }
        while (!stack2.isEmpty())stack1.push(stack2.pop());
        return temp;
    }

    /** Get the front element. */
    public int peek() {
        int temp=0;
        while (!stack1.isEmpty()){
            temp=stack1.pop();
            stack2.push(temp);
        }
        while (!stack2.isEmpty())stack1.push(stack2.pop());
        return temp;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
