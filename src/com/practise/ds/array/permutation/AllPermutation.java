//https://leetcode.com/problems/permutations/description/
// Tried Permutation for String -> https://github.com/gopalakrishnan-anbumani/AlgoDS/blob/main/src/com/practise/ds/string/permutation/AllPermutation.java
class AllPermutation {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length <= 1){
            List<List<Integer>> ls = new ArrayList();
            List<Integer> a = new ArrayList();
            a.add(nums[nums.length -1]);
            ls.add(a);
            return ls;
        }
        int lastInt = nums[nums.length -1];
        int[] allIntExpectLast = Arrays.copyOfRange(nums, 0, nums.length -1);
        List<List<Integer>> results = permute(allIntExpectLast);

        List<List<Integer>> permutations = new ArrayList();
        for(List<Integer> result : results){
            for(int i = 0; i <= result.size(); i++){
            //for(int i = 0; i <= allIntExpectLast.length; i++){
                List<Integer> permutation = new ArrayList();
                for(int j=0; j < i; j++){
                    permutation.add(result.get(j));
                }
                permutation.add(lastInt);
                for(int k=i; k < result.size(); k++){
                    permutation.add(result.get(k));
                }
                //
                //if(permutation.size() == nums.length){
                    permutations.add(permutation);
                //}
                
            }
        }
        return permutations;
    }
}
