//605. Can Place Flowers
//https://leetcode.com/problems/can-place-flowers/description/
//Leet Code - Daily Challenge - 20-03-2023

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 0){
                if((i-1 < 0 || flowerbed[i-1] == 0) && ( i+1 >= flowerbed.length || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    res++;
                    if(res == n){
                        return true;
                    }
                }
            }
        }
        return res>=n;
    }
}
