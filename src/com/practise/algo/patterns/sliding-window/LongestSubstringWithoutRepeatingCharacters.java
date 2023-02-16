//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//Eduactive - Pattern Coding - Sliding Window

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int r = 0;
        int l = 0;
        int[] hash = new int[256];
        boolean duplicateFound = false;
        while(r < s.length()){
            hash[s.charAt(r)]++;

            //Check any duplicates found.
            if(hash[s.charAt(r)] > 1){
                //If no duplicates present, ans won't be updated.
                duplicateFound = true;
                //From left to right can be a substring without repeating char.
                if(r - l > ans){
                    ans = r - l;
                }

                //Try to move the left pointer to remove/avoid the repeated char.
                while(hash[s.charAt(l)] == 1){
                    hash[s.charAt(l)]--;
                    l++;
                }
                hash[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        return duplicateFound ? Math.max(r - l,ans) : s.length();
    }
}
