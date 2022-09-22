class MedianTwoSortedArray {
    // Optimised Solution. Used Binary search to smaller array 
    //Take You Forward -https://www.youtube.com/watch?v=NTop3VTjmxk
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        //Perform Binary Search in Smaller Array. Bcs it'll take less time to finalise the partitions.
        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int size1 = nums1.length;
        int size2 = nums2.length;
        
        int low = 0;
        int high = size1;
        
        while(low <= high) {
            
            int cut1 = (low + high) / 2;
            int cut2 = ((size1 + size2 + 1) / 2) - cut1;   // If total size is odd, the median should come to left partition. so adding 1 here. 
                      
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1] ;
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = cut1 == size1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == size2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1){
                if((size1 + size2) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if(l1 > r2) {
                high = cut1 -1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
    
    // Solution - Didn't used Binary Search
    // Own logic implemented from https://www.youtube.com/watch?v=NTop3VTjmxk
    // Median of two Sorted Arrays of Different Sizes | Binary Search - TUF
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if(size2 < size1){
            return findMedianSortedArrays(nums2, nums1);
        }
        int i = size1 / 2;
        int totalSize = (size1 + size2 + 1) / 2;
        int j = totalSize - i;
        int x = 0; int y = 0;
        boolean exit = false;

        do {
            int l1 = (i - 1) >= 0 && size1 > 0 ? nums1[i-1] : Integer.MIN_VALUE;
            int l2 = (j - 1) >= 0 && size2 > 0 ? nums2[j-1] : Integer.MIN_VALUE;
            int r1 = i < size1 ? nums1[i] : Integer.MAX_VALUE;
            int r2 = j < size2 ? nums2[j] : Integer.MAX_VALUE;
            if(l1 > r2){
                exit = true;
                j+=1;
                i-=1;
            } else if(l2 > r1) {
                exit = true;
                i+=1;
                j-=1;
            } else {
                exit = false;
                x = Math.max(l1,l2);
                y = Math.min(r1, r2);
                System.out.println(x + " " + y);
            }
        } while(exit);
        if((size1 + size2) % 2 == 0){
            return (x+y) / 2.0;    
        } else {
            return x;
        }
    }
    
    public double findMedianSortedArrays(int[] array1, int[] array2) {
    int l1 = array1.length;
    int l2 = array2.length;
    int mid = (l1 + l2) / 2;
    if(mid ==0){
        return l1 == 0 ? array2[0] : array1[0];
    }
        
    boolean isEven = (l1+l2) % 2 == 0 ? true : false;
    int N1 = 0;
    int N2 = 0;
    int count = 0;
    int i=0; int j=0;
    while(count <= mid){
        N1 = N2;
        if(i < l1 && j < l2 && array1[i] <= array2[j] ){
            N2 = array1[i];
            i++;
        } else if(j < l2){
            N2 = array2[j];
            j++;
        } else {
            if(l1 == 0){
                N2 = array2[j];
                j++;
            } else {
                N2 = array1[i];
                i++;
            }
        }
        count++;
    } 

    if(isEven){
        return (double)(N1+N2)/2;
    } else {
        return N2;
    }
    }
}
