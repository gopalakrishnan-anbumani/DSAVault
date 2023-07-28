//91. Decode Ways
//https://leetcode.com/problems/decode-ways/description/


import java.util.HashMap;

class DecodeWays {

    //DP
    public int numDecodingsNPass(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)!='0'){
                dp[i] = dp[i+1];
            }
            if(i<s.length()-1){
                int num = (Integer.parseInt(String.valueOf(s.charAt(i))) * 10)
                        + Integer.parseInt(String.valueOf(s.charAt(i+1)));
                if(num >9 && num<27){
                    dp[i]=dp[i+1]+dp[i+2];
                }
            }
        }
        return dp[0];
    }

    //Recursion
    HashMap<String, Integer> hm = new HashMap<>();
    public int numDecodings(String s) {
        return decodeRec(s);
    }
    public int decodeRec(String s){
        if(s.isEmpty()){
            return 1;
        }
        if(hm.containsKey(s)){
            return hm.get(s);
        }
        int res = 0;
        int c = Integer.parseInt(String.valueOf(s.charAt(0)));
        if(c>=1 && c<=26){
            res += decodeRec(s.substring(1));
        }
        if((c==1 || c==2) && s.length() > 1){
            int c1 = (c*10) + Integer.parseInt(String.valueOf(s.charAt(1)));
            if(c1>=10 && c1<=26){
                res+= decodeRec(s.substring(2));
            }
        }
        hm.put(s, res);
        return hm.get(s);
    }
}