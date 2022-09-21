class FindDuplicates {
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
