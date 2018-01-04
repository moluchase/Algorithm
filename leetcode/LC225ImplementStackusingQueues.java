import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pengsong
 * @date 18/1/2 上午9:36
 */
/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
 */
public class LC225ImplementStackusingQueues {
    Queue<Integer> queue1,queue2;
    /** Initialize your data structure here. */
    public LC225ImplementStackusingQueues() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp=0;
        while (!queue1.isEmpty()){
            temp=queue1.poll();
            if(!queue1.isEmpty())queue2.add(temp);
        }
        while (!queue2.isEmpty())queue1.add(queue2.poll());
        return temp;
    }

    /** Get the top element. */
    public int top() {
        int temp=0;
        while (!queue1.isEmpty()){
            temp=queue1.poll();
            queue2.add(temp);
        }
        while (!queue2.isEmpty())queue1.add(queue2.poll());
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
