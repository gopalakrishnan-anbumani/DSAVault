//91. Decode Ways
//https://leetcode.com/problems/decode-ways/description/


import java.util.HashMap;

class DecodeWays {
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