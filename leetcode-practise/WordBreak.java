//139. Word Break
//https://leetcode.com/problems/word-break/description/


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