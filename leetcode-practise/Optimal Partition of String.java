//2405. Optimal Partition of String
//https://leetcode.com/problems/optimal-partition-of-string/description/
//LeetCode - Daily Challenge

class Solution {
    public int partitionString(String s) {
        int result = 0;
        List<Character> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(list.contains(ch)){
                result++;
                list = new ArrayList<>();
                list.add(ch);
            } else {
                list.add(ch);
            }
        }
        return result+1;

    }
}
