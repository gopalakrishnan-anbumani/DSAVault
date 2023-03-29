//278. First Bad Version
//https://leetcode.com/problems/first-bad-version/description/
//Eduactive - Pattern - Modified Binary Search

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        int res=-1;
        while(low<=high){
            int middle = (high-low)/2 + low;
            if(isBadVersion(middle)){
                res = middle;
                high = middle-1;
            } else {
                low = middle+1;
            }
        }
        return res;
    }
}
