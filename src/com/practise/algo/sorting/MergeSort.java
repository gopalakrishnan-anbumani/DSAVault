// "static void main" must be defined in a public class.
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,4,6,1,6,2};
        divide(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
    public static void divide(int[] arr, int l, int r) {
        if(l < r){
            int mid = (l + r) / 2;
            divide(arr, l, mid);
            divide(arr, mid + 1, r);
            sort(arr, l, mid, r);           
        }
    }
    public static void sort(int[] arr, int l, int mid, int r) {
        //size of 2 arrays
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        
        
        for(int i=0;i<n1;i++){
            a1[i] = arr[l+i];
        }
        for(int j=0;j<n2;j++) {
            a2[j] = arr[mid+1+j];
        }
        
        int i=0,j=0,k=0;
        
        while(i < n1 && j < n2){
            if(a1[i] < a2[j]){
                arr[l+k] = a1[i];
                i++;
            } else {
                arr[l+k] = a2[j];
                j++;
            }
            k++;
        }
        
        for(int x=i;x<n1;x++){
            arr[l+k] = a1[x];
            k++;
        }
        for(int x=j;x<n2;x++){
            arr[l+k] = a2[x];
            k++;
        }
    }
}
