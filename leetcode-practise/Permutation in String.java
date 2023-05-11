//567. Permutation in String
//https://leetcode.com/problems/permutation-in-string/description/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n2 < n1){
            return false;
        }
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i=0; i< n1; i++){
            hash1[s1.charAt(i) - 'a']++;
        }
        int start = 0;
        for(int end = 0; end < n2; end++){
            hash2[s2.charAt(end) - 'a']++;
            if(end - start + 1 == n1){
                int i = 0;
                while(i < n1 && hash1[s1.charAt(i) - 'a'] == hash2[s1.charAt(i) - 'a']){
                    i++;
                }
                if(i >= n1){
                    return true;
                }
                hash2[s2.charAt(start) - 'a']--;
                start++;
            }
        }
        return false;
    }
}
