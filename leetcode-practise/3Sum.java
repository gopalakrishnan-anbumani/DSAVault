//15. 3Sum
//https://leetcode.com/problems/3sum/description/
//NeetCode - 2 Pointer

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        Arrays.sort(nums);
        while(i<nums.length-2){
            int numi = nums[i];
            int j = i+1;
            int k = n-1;
            if(i>0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            while(j<k){
                List<Integer> list = new ArrayList<>();
                int numj = nums[j];
                int numk = nums[k];
                int sum = numi+numj+numk;
                if(sum == 0){
                    list.add(numi);
                    list.add(numj);
                    list.add(numk);
                    res.add(list);
                    j++;
                    while(nums[j] == nums[j-1] && j < k){
                        j++;
                    }
                } else if(sum > 0){
                    k--;
                } else {
                    j++;
                }
            }
            i++;
        }
        return res;
    }
}
