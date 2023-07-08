//139. Word Break
//https://leetcode.com/problems/word-break/description/

//NeetCode Solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--){
            for(String str : wordDict){
                if(i+str.length() <= s.length() && s.substring(i, i+str.length()).equals(str)){
                    dp[i] = dp[i+str.length()];
                    if(dp[i]){
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}

class Solution {
    List<String> list = null;
    int max = 0;
    HashMap<String, Boolean> hm = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        list = wordDict;
        for(String str : list ){
            max = Math.max(max, str.length());
        }
        return breakRec(s);
    }

    public boolean breakRec(String s){
        if(s.length()==0){
            return true;
        }
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        for(int i=0;i<s.length();i++){
            if(i>max){
                break;
            }
            String brk = s.substring(0, i+1);
            if(list.contains(brk)){
                String newStr = s.substring(i+1);
                if(breakRec(newStr)){
                    return true;
                }
            }
        }
        if(!hm.containsKey(s)){
            hm.put(s, false);
        }
        return hm.get(s);
    }
}