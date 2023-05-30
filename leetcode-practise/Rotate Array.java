//189. Rotate Array
//https://leetcode.com/problems/rotate-array/description/

class Solution {
    public void rotate(int[] nums, int k) {
        int s = k % nums.length;
        int index = 0;
        while(s > 0){
            int temp = nums[index];
            int nextPos = (index + k)%nums.length;
            while(nextPos!=index){
                int t = nums[nextPos];
                nums[nextPos] = temp;
                temp = t;
                if((nextPos + k) >= nums.length){
                    s--;
                }
                nextPos = (nextPos + k) % nums.length;
            }
            nums[index] = temp;
            index++;
            
        }
        System.gc();
        
    }
}


