//https://leetcode.com/problems/majority-element/description/
//Greedy Algorithm - Youtube
class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        Set keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        int N = nums.length / 2;
        int res = -1;
        while(it.hasNext()){
            int num = it.next();
            int count = map.get(num);
            if(count > N){
                res = num;
            }
        }
        return res;
    }
    
    //Using Sorting
    //O(Log(N))
    //https://leetcode.com/problems/majority-element/solutions/127412/majority-element/
    /* Majority Element present in array more than the N/2. So Obvisouly majority element present at N/2 Position if sorted.*/
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
