//https://leetcode.com/problems/minimum-time-to-complete-trips/description/
//2187. Minimum Time to Complete Trips
//LeetCode Daily Challenge
//March - 7 - 2023


class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int low = 1;
        int high = Integer.MAX_VALUE;
        while(low < high){
            int currentTime = low + (high-low) / 2;
            int totalTimeTaken = 0;
            for(int i = 0; i < time.length; i++){
                int tripTime = time[i];
                totalTimeTaken = totalTimeTaken + (currentTime/tripTime);
            }
            if(totalTimeTaken >= totalTrips){
                high = currentTime;
            } else if(totalTimeTaken < totalTrips){
                low = currentTime + 1;
            }
        }

        return low;
    }
}
