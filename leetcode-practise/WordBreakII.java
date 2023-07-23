//WordBreakII
//140. Word Break II
//https://leetcode.com/problems/word-break-ii/description/


import java.util.ArrayList;
import java.util.List;

class WordBreakII {
    String s = null;
    List<String> dict = null;
    List<String> result=new ArrayList<>();
    public List<String> wordBreak(String string, List<String> wordDict) {
        s = string;
        dict = wordDict;
        wordBreakRec(0, "");
        return result;
    }

    public String wordBreakRec(int index, String res){
        if(index >= s.length()){
            return res.substring(0, res.length()-1);
        }
        for(String w : dict){
            if(index+w.length() <= s.length() && s.startsWith(w, index)){
                String newRes = res + w + " ";
                String output = wordBreakRec(index+w.length(), newRes);
                if(output != null){
                    result.add(output);
                }
            }
        }
        return null;
    }
}