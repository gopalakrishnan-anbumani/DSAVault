//459. Repeated Substring Pattern
//https://leetcode.com/problems/repeated-substring-pattern/description/

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=s.length()/2; i>=1;i--){
            if(s.length() % i == 0){
                String str = s.substring(0, i);
                int idx = 0;
                while(idx+i <= s.length() && str.equals(s.substring(idx, idx+i))){
                    idx += i;
                }
                if(idx >= s.length()){
                    return true;
                }
            }
        }
        return false;
    }
}