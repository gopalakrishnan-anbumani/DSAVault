//2357. Make Array Zero by Subtracting Equal Amounts
//https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
//Effective Solution 


class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0){
                set.add(num);
            }
        }
        return set.size();
    }
}

//Used Heap
class Solution1 {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int[] nums1=null;
    public int minimumOperations1(int[] nums) {
        nums1 = nums;
        int count=0;
        moveToPQ();
        while(!pq.isEmpty()){
            int min = pq.poll();
            int i=0;
            for(int num : nums1){
                int temp = Math.max(0, num-min);
                nums1[i++] = temp;
            }
            pq = new PriorityQueue<>();
            moveToPQ();
            count++;
        }
        return count;
    }
    public void moveToPQ(){
        for(int num : nums1){
            if(num > 0){
                pq.add(num);
            }
        }
    }
}
