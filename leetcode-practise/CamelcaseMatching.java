//1023. Camelcase Matching
//https://leetcode.com/problems/camelcase-matching/description/

import java.util.ArrayList;
import java.util.List;

class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for(String query : queries){
            list.add(check(query, pattern));
        }
        return list;
    }
    public Boolean check(String s, String p){
        int i= 0;
        int j = 0;
        while(i<s.length() && j<p.length()){
            if(s.charAt(i) == p.charAt(j)){
                j++;
            } else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                return false;
            }
            i++;
        }
        if(j!=p.length()){
            return false;
        }
        while(i<s.length()){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                return false;
            }
            i++;
        }
        return true;
    }
}