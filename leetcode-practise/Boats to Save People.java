//881. Boats to Save People
//https://leetcode.com/problems/boats-to-save-people/description/
//Leetcode - Daily Challenge - 03-04-2023


class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int start = 0;
        int end = people.length-1;

        while(start <= end){
            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
            count++;
        }

        return count;
    }
}
