//2390. Removing Stars From a String
//https://leetcode.com/problems/removing-stars-from-a-string/description/
//LeetCode - Daily Challenge

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && ch == '*'){
                stack.pop();
            } else if(ch!='*'){
                stack.push(ch);
            }
        }
        String res = new String();
        for(int i = stack.size()-1;i>=0;i--){
            res = stack.pop() + "" + res;
        }
        return res.toString();
    }
}
