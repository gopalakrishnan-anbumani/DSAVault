//Eduactive Question
//https://www.geeksforgeeks.org/sparse-search/
class SparseSearch
{
    public static int searchForString(String[] array, String target) 
    {
        return search(array, target, 0, array.length-1);
    }

    public static int search(String[] arr, String target, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start+end) / 2;
        if(arr[mid] == "" ){
            int l = mid - 1;
            int r = mid + 1;
            while(true){
                if(l < start && r > end){
                    return -1;
                } else if(l >= start && arr[l] != ""){
                    mid = l;
                    break;
                } else if(r <= end && arr[r] != ""){
                    mid = r;
                    break;
                }
                l--;
                r++;
            }
        }
        if(arr[mid] == target){
            return mid;
        } else if(arr[mid].compareTo(target) < 0) {
            return search(arr,target,mid+1, end);
        } else {
            return search(arr,target,start, mid-1);
        }
    }
}
