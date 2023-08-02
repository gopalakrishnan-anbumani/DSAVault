//46. Permutations
//https://leetcode.com/problems/permutations/description/

class Permutations {
    int k = 0;
    List<List<Integer>> result = new ArrayList<>();
    int[] num = null;
    public List<List<Integer>> permute(int[] nums) {
        k = nums.length;
        num = nums;
        backTrack(0, new ArrayList<>());
        return result;
    }

    public void backTrack(int count, List<Integer> list){
        if(count == k){
            result.add(new ArrayList<>(list));
        }

        for(int i=0;i<k;i++){
            if(!list.contains(num[i])){
                list.add(num[i]);
                backTrack(count+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}
