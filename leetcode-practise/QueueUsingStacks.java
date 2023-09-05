//232. Implement Queue using Stacks
//https://leetcode.com/problems/implement-queue-using-stacks/description/

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int pop = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public int peek() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int peek = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return peek;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * QueueUsingStacks obj = new QueueUsingStacks();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */