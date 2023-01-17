//Eduactive Pattern Problem - Two Pointers

import java.util.*;
public class ValidPalindrome{
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    
//Palindrome Another Pblm from leetcode
//https://leetcode.com/problems/valid-palindrome/description/
class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                str+=c;
            } else if(c >= 'A' && c <= 'Z'){
                c = (char) (c + 'a' - 'A');
                str+=c;
            } else if(c >= '0' && c <= '9'){
                str+=c;
            }
        }
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
