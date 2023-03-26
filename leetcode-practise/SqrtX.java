//69. Sqrt(x)
//https://leetcode.com/problems/sqrtx/description/
//Leet Code - Practise

class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        int res = 0;
        while(low <=  high){
            long mid = (low+high)/2;
            if(mid*mid == x){
                return (int)mid;
            }
            if(mid*mid > x){
                high = mid -1;
            } else if(mid*mid < x){
                low = mid + 1;
                res = (int)mid;
            }
        }
        return res;
    }
}
