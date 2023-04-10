//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/description/
//LeetCode - Daily challenge

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            if(ch == ')' || ch == ']' || ch == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(ch == ')' && pop != '('){
                    return false;
                }
                if(ch == '}' && pop != '{'){
                    return false;
                }
                if(ch == ']' && pop != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
