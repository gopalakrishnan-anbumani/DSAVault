//https://www.codingninjas.com/codestudio/problems/minimum-window-subsequence_2181133?leftPanelTab=0


public class MinWindowSubsequence {
    public static String minWindow(String S, String T) {
        
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
