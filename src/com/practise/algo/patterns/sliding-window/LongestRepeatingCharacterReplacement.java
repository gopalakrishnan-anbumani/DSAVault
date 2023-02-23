//LeetCode - https://leetcode.com/problems/longest-repeating-character-replacement/description/
class Solution {
    static int characterReplacement(String s, int k) {
        // code here
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
  
  
    //My Solution. not completed.
    public int characterReplacement1(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a,b) -> hm.get(b)-hm.get(a));
        int max = Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            if(hm.containsKey(ch) && hm.get(ch) > 0){
                hm.put(ch, hm.get(ch)+1);
            } else {
                hm.put(ch, 1);
                pq.add(ch);
            }
            if(2 - 1 <= k){
                max = Math.max(max, right - left + 1);
            }
            if(2 - 1 < k){
                System.out.println(hm);
                System.out.println(pq);
                char leftCh = s.charAt(left);
                hm.put(ch, hm.get(ch)-1);
                if(hm.get(leftCh) == 0){
                    //2--;
                }
                left++;
            }
            right++;
        }
        return max;
    }
  
}
