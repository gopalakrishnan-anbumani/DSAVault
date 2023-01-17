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
