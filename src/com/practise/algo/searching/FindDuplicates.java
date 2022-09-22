class FindDuplicates {
    //Optimized Solution - No Extra Space. & O(n) time complexity
    // Youtube - https://www.youtube.com/watch?v=8ci8WfQ6cns
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] > 0){
                nums[num-1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;
    }
    
    // This solution is not optimized. Use Constant Space 
    public List<Integer> findDuplicates(int[] nums) {
        int count = 0;
        int n = nums.length;
        
        List<Integer> result = new ArrayList();
        List<Integer> numss = new ArrayList();
        while(count < n){
            int num = nums[count];
            if(numss.contains(num)){
                result.add(num);
            } else {
                numss.add(num);
            }
            count++;
        }
        return result; 
    }
}
