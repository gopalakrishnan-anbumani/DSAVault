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

	//Sliding Window Concept - GeeksForGeeks
class Solution1 {
    public String minWindow(String A, String B) {
        int m[] = new int[256];
        char[] s = A.toCharArray();
        char[] t = B.toCharArray();
        // Answer
        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;
        // creating map
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        }
 
        // References of Window
        int i = 0;
        int j = 0;
 
        // Traversing the window
        while (j < s.length) {
 
            // Calculations
            m[s[j]]--;
            if (m[s[j]] == 0)
                count--;
 
            // Condition matching
            if (count == 0) {
                while (count == 0) {
 
                    // Sorting ans
                    if (ans > j - i + 1) {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }
 
                    // Sliding I
                    // Calculation for removing I
                    m[s[i]]++;
                    if (m[s[i]] > 0)
                        count++;
 
                    i++;
                }
            }
            j++;
        }
 
        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start,
                                               ans + start);
        else
            return ""; 
    }
}
	

}
