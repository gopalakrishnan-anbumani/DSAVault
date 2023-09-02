//1249. Minimum Remove to Make Valid Parentheses
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/

import java.util.Stack;

class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : arr){
            if(ch == ')'){
                if(!stack.isEmpty() && count>0){
                    count--;
                    StringBuilder strb = new StringBuilder();
                    String poped = stack.pop();
                    while(!poped.equals("(")){
                        strb.insert(0, poped);
                        poped = stack.pop();
                    }
                    stack.push(poped+strb.toString()+")");
                }
            } else {
                if(ch=='('){
                    count++;
                }
                stack.push(ch+"");
            }
        }

        while(!stack.isEmpty()){
            String pop = stack.pop();
            if(!pop.equals("(") && !pop.equals(")")){
                sb.insert(0, pop);
            }
        }

        return sb.toString();
    }
}