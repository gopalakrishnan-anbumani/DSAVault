//744. Find Smallest Letter Greater Than Target
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/?envType=study-plan-v2&id=binary-search


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int ans=0;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(letters[middle] == target){
                start = middle+1;
            } else if(letters[middle] > target){
                ans = middle;
                end = middle-1;
            } else {
                start = middle+1;
            }
        }
        return letters[ans];
    }
}
