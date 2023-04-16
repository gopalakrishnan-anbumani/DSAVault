//17. Letter Combinations of a Phone Number
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//Eduative - Pattern - subset

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for(Character digit : digits.toCharArray()){
            switch(digit+"") {
                case "2" : 
                    result = addLetter(result, "abc");
                break;
                case "3" : 
                    result = addLetter(result, "def");
                break;
                case "4" : 
                    result = addLetter(result, "ghi");
                break;
                case "5" : 
                    result = addLetter(result, "jkl");
                break;
                case "6" : 
                    result = addLetter(result, "mno");
                break;
                case "7" : 
                    result = addLetter(result, "pqrs");
                break;
                case "8" : 
                    result = addLetter(result, "tuv");
                break;
                case "9" : 
                    result = addLetter(result, "wxyz");
                break;
            }
        }
        return result;
    }
    public List<String> addLetter(List<String> result, String str){
        List<String> ans = new ArrayList<>();
        if(result.isEmpty()){
            for(int i=0;i<str.length();i++){
                ans.add(str.charAt(i)+"");
            }
        } else {
            for(String s : result){
                for(int i=0;i<str.length();i++){
                    ans.add(s+str.charAt(i));
                }
            }
        }
        return ans;
    }
}
