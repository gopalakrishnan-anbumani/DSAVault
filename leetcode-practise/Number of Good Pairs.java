//1512. Number of Good Pairs
//https://leetcode.com/problems/number-of-good-pairs/description/


class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int k = 10;
        int n1 = s.length();
        if(s.length() <= k){
            return result;
        }
        int s1 = 0;
        HashMap<String, Integer> hm = new HashMap();
        while(s1+k <= n1){
            if(hm.containsKey(s.substring(s1,s1+k)) && !result.contains(s.substring(s1,s1+k))){
                result.add(s.substring(s1,s1+k));
            } else {
                hm.put(s.substring(s1,s1+k), 1);
            }
            s1++;
        }
       
        return result;
    }

}
