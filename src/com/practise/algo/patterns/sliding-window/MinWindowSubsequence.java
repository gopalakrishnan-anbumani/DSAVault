//https://www.codingninjas.com/codestudio/problems/minimum-window-subsequence_2181133?leftPanelTab=0


public class MinWindowSubsequence {
    //Optimised solution
    public static String minWindow(String S, String T) {
        
        // Initially our window is empty
        String window = "";
        int j = 0, min = S.length() + 1;
        
        for (int i = 0; i < S.length(); i++) {
            
            // If characters are same, then increment the j pointer
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                
                // If we finally reach the end of string T, we can start shrinking our window
                if (j == T.length()) {
                    int end = i + 1;
                    j--;
                    
                    // We are doing j-- in order to minimise our window size
                    while (j >= 0) {
                        if (S.charAt(i) == T.charAt(j)) {
                            j--;
                        }
                        i--;
                    }
                    
                    // Incrementing i and j for next iteration
                    j++;
                    i++;
                    
                    // Updating our window, if we found an element of minimum length
                    if (end - i < min) {
                        
                        // Updating minimum
                        min = end - i;
                        
                        // Updating window
                        window = S.substring(i, end);
                    }
                }
            }
        }
        
        //returning our final answer, which is stored in window
        return window;
        
    }
}
    
    
    //My Solution
    public static String minWindow1(String S, String T) {
        
        int tLength = T.length();
        int sLength = S.length();
        int t = 0;
        int startIndex = 0;
        int endIndex = Integer.MAX_VALUE;
        for(int i=0;i<sLength;i++){
            int sStart = i;
            int tStart = 0;
            int count = 0;
            while(tStart < tLength && sStart < sLength){
                if(S.charAt(sStart) == T.charAt(tStart)){
                    count++;
                    if(count == tLength){
                        if(endIndex - startIndex > sStart - i){
                            startIndex = i;
                            endIndex = sStart;
                        }
                        break;
                    }
                    sStart++;
                    tStart++;
                } else {
                    sStart++;
                }
                
            }
        }
        if(endIndex == Integer.MAX_VALUE){
            return "";    
        }
        return S.substring(startIndex, endIndex+1);
        
    }
}
