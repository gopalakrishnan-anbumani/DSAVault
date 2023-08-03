//17. Letter Combinations of a Phone Number
//LetterCombinationsOfAPhoneNumber
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//https://github.com/gopalakrishnan-anbumani/DSAVault/blob/main/src/com/practise/algo/patterns/subsets/LetterCombinationsofaPhoneNumber.java
//BackTracking 
//SubSet

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber {
    String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        backTrack(digits, 0, new StringBuffer());
        return ans;
    }

    public void backTrack(String digits, int index, StringBuffer sb){
        if(index >= digits.length()){
            if(sb.length()!=0){
                ans.add(sb.toString());
            }
            return;
        }
        char[] word = letters[digits.charAt(index) - '0'].toCharArray();
        for(char ch : word){
            sb.append(ch);
            backTrack(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public List<String> letterCombinations1(String digits) {
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