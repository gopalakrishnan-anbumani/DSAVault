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

}
