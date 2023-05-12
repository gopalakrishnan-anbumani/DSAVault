//567. Permutation in String
//https://leetcode.com/problems/permutation-in-string/description/
//Added Optimised Solution

class Solution {
    //T.C -> 0(N) 
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
            hash2[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i=0;i<26;i++){
            if(hash1[i] == hash2[i]){
                matches++;
            }
        }
        int start = 0;
        for(int end = n1; end < n2; end++){
            if(matches == 26){
                return true;
            }
            --hash2[s2.charAt(start) - 'a'];
            int index1=s2.charAt(start) - 'a';
            start++;
            if(hash1[index1] == hash2[index1]){
                matches++;
            } else if(hash1[index1] - 1== hash2[index1]) {
                matches--;
            }
            ++hash2[s2.charAt(end) - 'a'];
            int index2=s2.charAt(end) - 'a';
            if(hash1[index2] == hash2[index2]){
                matches++;
            } else if(hash1[index2] + 1 == hash2[index2]) {
                matches--;
            }
        }
        System.gc();
        return matches == 26;
    }
    
    //T>C -> 0(N.M). We can make it O(26.N)
    public boolean checkInclusion1(String s1, String s2) {
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
