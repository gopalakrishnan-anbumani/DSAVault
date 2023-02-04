//https://leetcode.com/problems/sliding-window-maximum/description/
//Eduactive - Pattern Coding - Sliding Window

/*Optimised Solution*/
//Try to add Comments for each step*****
class FindMaxInWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result =  new int[n-k+1];
        k = k < n ? k : n;
        int index=0;
        Deque<Integer> window = new ArrayDeque<Integer>();

        for(int i=0;i<k;i++){
            while(!window.isEmpty() && nums[i] >=  nums[window.peekLast()]){
                window.removeLast();
            }
            window.addLast(i);
        }
        System.out.println(window);
        result[index++] = nums[window.peek()];
        for(int i = k; i < n; i++){
            while(!window.isEmpty() && nums[i] >= nums[window.peekLast()]){
                window.removeLast();
            }
            if(!window.isEmpty() && window.peek() <= (i-k)){
                window.removeFirst();
            }
            window.add(i);
            result[index++] = nums[window.peek()];
        }   
        return result;
    }
    public int findMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }
}

/*Used Window by 2 Pointers. Finding maximum between the pointers. 
Getting Time Exceeded Problem for Large set of inputs. 
Solved Using Deque for good Time Complexity*/
class FindMaxInWindow1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        k = k < n ? k : n;
        int start = 0;
        int[] result =  new int[n-k+1];
        while(k <= n){
            result[start] = findMax(nums, start, k);
            start++;
            k++;
        }
        return result;
    }
    public int findMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }
}
