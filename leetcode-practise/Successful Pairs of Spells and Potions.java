//2300. Successful Pairs of Spells and Potions
//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
//LeetCode - Daily Challenge - 02/04/2023

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        int size = potions.length;
        int j=0;
        for(int spell : spells){
            int low = 0;
            int high = size-1;
            int mid = 0;
            int idx = size;
            while(low <= high){
                mid = low + (high-low)/2;
                long mul = (long)spell * (long)potions[mid];
                if(mul < success){
                    low = mid+1;
                } else {
                    idx = mid;
                    high = mid -1;
                }
            }
            result[j++] = size - idx;
        }
        return result;
    }
}
