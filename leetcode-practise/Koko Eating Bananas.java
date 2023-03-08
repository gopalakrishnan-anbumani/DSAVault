//875. Koko Eating Bananas
//https://leetcode.com/problems/koko-eating-bananas/description/
//Leet Code Daily Challenge - 03-08-2023

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = piles[piles.length-1];
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (right + left) / 2;
            long count = 0;
            for(int j=0;j<piles.length;j++){
                int pile = piles[j];
                count = count + (long)Math.ceil(((double)pile / (double)mid));
            }
            if(count <= h){
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
