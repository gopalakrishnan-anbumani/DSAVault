//LetterCombinationsOfAPhoneNumber
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//https://github.com/gopalakrishnan-anbumani/DSAVault/blob/main/src/com/practise/algo/patterns/subsets/LetterCombinationsofaPhoneNumber.java
//BackTracking 
//SubSet

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

}
