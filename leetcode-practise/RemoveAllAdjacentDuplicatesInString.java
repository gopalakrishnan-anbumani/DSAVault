//1047. Remove All Adjacent Duplicates In String
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/


import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.insert(0,stack.pop());
        }
        return str.toString();
    }
}