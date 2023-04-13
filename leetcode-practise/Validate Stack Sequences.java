//946. Validate Stack Sequences
//https://leetcode.com/problems/validate-stack-sequences/description/


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(index < popped.length && !stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
