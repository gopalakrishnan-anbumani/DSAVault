//1047. Remove All Adjacent Duplicates In String
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/


import java.util.Stack;

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for(Character ch : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            } else {
                Character prev = stack.pop();
                if(prev != ch){
                    stack.push(prev);
                    stack.push(ch);
                }
            }
        }
        String str = "";
        while(!stack.isEmpty()){
            str =  stack.pop() + str + "";
        }
        return str;
    }
}