//https://leetcode.com/problems/valid-palindrome-ii/description/
class ValidPalindrom2 {
  
  
  //Code Passed in Eduactive. Failed in LeetCode
  //Failed Input : "ebcbbececabbacecbbcbe"
    public boolean validPalindrome(String s) {
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
