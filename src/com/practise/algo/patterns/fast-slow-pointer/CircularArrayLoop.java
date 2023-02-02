//https://leetcode.com/problems/circular-array-loop/description/
//Eduactive - Fast Slow Pointer

class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {

        int slow = 0;
        int n = nums.length;
        int fast = slow;
        int forward = 0;
        int backward = 0;
        int count = 0; 
        while(slow < n){
            System.out.println(fast);
            int previousFast = fast;
            int jump = (nums[fast]) % n;
            if(nums[fast] > 0) {      //Forward Jump
                forward++;
                count++;
                fast = (fast + jump) % n;
            } else {            // Backward Jump
                backward++;
                count++;
                fast = (fast + jump) >= 0 ? (fast + jump) : n + (fast + jump);
            }
            if((forward >= 1 && backward >= 1) || (forward > n || backward > n) || previousFast == fast){
                System.out.println("break" + slow);

                slow++;
                forward=0; 
                backward=0;
                fast=slow;
            }
            if(slow == fast && ((forward > 1 && backward == 0) || (forward == 0 && backward > 1))){
                System.out.println("restult" + slow);
                return true;                
            }

            
        }
        return false;
    }
}
