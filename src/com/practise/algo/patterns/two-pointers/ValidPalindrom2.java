//https://leetcode.com/problems/valid-palindrome-ii/description/
class ValidPalindrom2 {
  //Correct Solution
  public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return checkPalindrome(s, left+1, right) || checkPalindrome(s, left, right-1);
            }
        }
        return true;
    }
    public boolean checkPalindrome(String s, int i, int j){

        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
  
  //Code Passed in Eduactive. Failed in LeetCode
  //Failed Input : "ebcbbececabbacecbbcbe"
    public boolean validPalindrome1(String s) {
        int left = 0;
        int right = s.length() -1;
        int count = 0;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                count+=1;
                if(left <= right && s.charAt(left) == s.charAt(--right)){
                    left++;
                    right--;
                } else if(left <= right && s.charAt(++left) == s.charAt(++right)){
                    left+=1;
                    right-=1;
                } else {
                    return false;
                }
            } 
        }
        return count <= 1 ? true : false;
    }
}
