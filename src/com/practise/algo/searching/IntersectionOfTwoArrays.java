//LeetCode - https://leetcode.com/problems/intersection-of-two-arrays/description/
//Solution tried in BST. Try in Two pointers
class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l2 < l1) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        List<Integer> intersectList = new ArrayList();
        for(Integer n2 : nums2){
            if(!find(intersectList, n2, 0, intersectList.size()-1)){
                if(find(nums1, n2, 0, nums1.length-1)){
                    intersectList.add(n2);
                }
            }
        }
        int[] result = new int[intersectList.size()];
        int i=0;
        for(Integer n2 : intersectList){
            result[i++] = n2;
        }
        return result;
    }
    public boolean find(List<Integer> list, int target, int start, int end){
        if(start > end){
            return false;
        }
        int median = (start + end) / 2;
        int num = list.get(median);
        if(num == target){
            return true;
        } else if(num > target) {
            return find(list, target, start, median-1);
        } else {
            return find(list, target, median+1, end);
        }
    }
    public boolean find(int[] list, int target, int start, int end) {
        if(start > end){
            return false;
        }
        int median = (start + end) / 2;
        int num = list[median];
        if(num == target){
            return true;
        } else if(num > target) {
            return find(list, target, start, median-1);
        } else {
            return find(list, target, median+1, end);
        }
    }
}
