//5. Longest Palindromic Substring
//https://leetcode.com/problems/longest-palindromic-substring/description/


class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        int size = s.length();
        
        for(int i=0;i<size;i++){
            //Odd Length
            int l = i;
            int r = i;
            while(l>=0 && r<size && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    max = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
            //Even Length
            l = i;
            r = i+1;
            while(l>=0 && r<size && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > max){
                    max = r-l+1;
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
