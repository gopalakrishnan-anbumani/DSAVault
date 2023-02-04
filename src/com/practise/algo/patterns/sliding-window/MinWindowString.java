//https://www.interviewbit.com/problems/window-string/
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
}
