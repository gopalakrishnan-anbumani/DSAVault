//155. Min Stack
//https://leetcode.com/problems/min-stack/description/

class MinStack {
    int top = -1;
    List<Integer> stack;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        top++;
        stack.add(val);
        pq.offer(val);
    }
    
    public void pop() {
        int pop = stack.get(top);
        stack.remove(top);
        pq.remove(pop);
        top--;
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
