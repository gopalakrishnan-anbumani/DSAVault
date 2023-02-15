//https://www.interviewbit.com/problems/window-string/
//https://leetcode.com/problems/minimum-window-substring/description/
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/

public class MinWindowString {
    public String minWindow(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        if(len2 > len1) {
        	return "";
        }
        
        int[] hash_pat= new int[256];
        int[] hash_str= new int[256];
        for(int i=0;i<len2;i++) {
        	hash_pat[B.charAt(i)]++;
        }
        int count=0;
        int start=0;
        int startIndex = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<len1;i++) {
        	
        	hash_str[A.charAt(i)]++;
        	
        	if(hash_str[A.charAt(i)] <= hash_pat[A.charAt(i)]) {
        		count++;
        	}
        	
        	if(count == len2) {
        		while(hash_str[A.charAt(start)] > hash_pat[(A.charAt(start))]
        				|| hash_pat[A.charAt(start)] == 0) {
        			if (hash_str[A.charAt(start)] > hash_pat[A.charAt(start)])
        				hash_str[A.charAt(start)]--;
        			start++;
        		}
        		
        		int window = i - start + 1;
        		if(min>window) {
        			min = window;
        			startIndex = start;
        		}
        	}
        }
        if(startIndex==-1) return "";
        return A.substring(startIndex,startIndex+min);   
    }
	
	
public class Solution {
	//My Implementation after knew the logic.
    public String minWindow1(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(n>m){
            return "";
        }
        int[] hash_s = new int[256];
        int[] hash_t = new int[256];
        for(int i=0;i<n;i++){
            hash_t[t.charAt(i)]++;
        }
        int count = 0;
        int minLen = m+1;
        int end = 0;
        String result = "";
        for(int i=0;i<m;i++){
            if(hash_t[s.charAt(i)] > 0){
                hash_s[s.charAt(i)]++;
                if(hash_t[s.charAt(i)] >= hash_s[s.charAt(i)]){
                    count++;
                }
            }
            if(count == n){
                end = i+1;
                int reverseCount = 0;
                int[] hash_r = new int[256];
                while(reverseCount<n){
                   if(hash_t[s.charAt(i)] > 0){
                       hash_r[s.charAt(i)]++;
                       if(hash_t[s.charAt(i)] >= hash_r[s.charAt(i)]){
                           reverseCount++;
                       }
                   }
                   i--;
                }
                i++;
                if(minLen > end - i){
                    minLen = end-i;
                    result = s.substring(i,end);

                }
                count=0;
                hash_s = new int[256];
            }
        }
        return result;
	
        
    }
}

}
