//78. Subsets
//https://leetcode.com/problems/subsets/description/
//Eduactive - Pattern - Subset

class Subsets {
  //TC -> O(n * 2^n) -> Do it in optimised
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num : nums){
            List<List<Integer>> result1 = new ArrayList<>();
            for(List<Integer> set : result){
                List<Integer> set1 = new ArrayList<Integer>(set);
                set1.add(num);
                result1.add(set1);
            }
            result.addAll(result1);
        }
        return result;
    }
}
