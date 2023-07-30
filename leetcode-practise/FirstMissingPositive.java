//41. First Missing Positive
//https://leetcode.com/problems/first-missing-positive/description/
//Cyclic Sort
//Hard - LeetCode

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while(idx < n){
            int num = nums[idx]; //if num 3 means. put it in 2 idx
            //swap
            if(num>0 && num<=n && idx+1 != num && nums[num-1] != num){
                //put num in num-1 place
                int temp = nums[num-1];
                nums[idx] = temp;
                nums[num-1] = num;
                continue;
            }
            idx++;
        }
        int x = 0;
        for(x=0;x<n;x++){
            if(x+1 != nums[x]){
                return x+1;
            }
        }
        return x+1;
    }
}