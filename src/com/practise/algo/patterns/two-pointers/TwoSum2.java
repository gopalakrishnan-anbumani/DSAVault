//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/


class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {

        int s = 0;
        int e = numbers.length-1;

        while(s < e){
            if(numbers[s] + numbers[e] == target){
                return new int[]{s+1,e+1};
            } else if(numbers[s] + numbers[e] > target){
                e--;
            } else {
                s++;
            }
        }
        return null;
        
    }
}

//Eduactive - patterns
https://www.educative.io/courses/grokking-coding-interview-patterns-java/N75vOogKyl6
