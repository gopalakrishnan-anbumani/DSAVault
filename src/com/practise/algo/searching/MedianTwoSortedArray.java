class MedianTwoSortedArray {
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
