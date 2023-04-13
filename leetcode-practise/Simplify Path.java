//71. Simplify Path
//https://leetcode.com/problems/simplify-path/description/

class Solution {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        System.out.println(Arrays.toString(folders));
        Stack<String> stack = new Stack<>();
        for(String folder : folders){
            if(folder.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if(!folder.equals("..")  && !folder.equals(".") && !folder.isEmpty()){
                stack.push(folder);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = "/" + stack.pop() + result;
        }
        return result.isEmpty() ? "/" : result;
    }
}
