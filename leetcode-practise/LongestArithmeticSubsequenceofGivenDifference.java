//1218. Longest Arithmetic Subsequence of Given Difference
//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max=1;
        for(int num : arr){
            hm.put(num, hm.getOrDefault(num-difference, 0)+1);
            max=Math.max(hm.get(num), max);
        }
        return max;
    }
}