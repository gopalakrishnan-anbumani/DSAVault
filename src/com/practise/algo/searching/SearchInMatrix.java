class SearchInMatrix {
  
    // Do Binary search in row wise then Binary Search in One Row. 
    public boolean searchMatrix(int[][] matrix, int target) {
        
     int numberOfRows = matrix.length;    
     int numberOfColumns = (numberOfRows > 0) ? matrix[0].length : 0;    
     int low = 0;
     int high = numberOfRows - 1;
     int mid = 0;   
     while(low <= high){
        mid = (low + high) / 2;
        if(matrix[mid][0] <= target && matrix[mid][numberOfColumns-1] >= target){
            //target Column
            int lowC = 0;
            int highC = numberOfColumns;
            while(lowC <= highC){
                int midC = (lowC + highC) / 2;
                if(matrix[mid][midC] == target){
                    return Boolean.TRUE;
                } else if(matrix[mid][midC] < target){
                   lowC = midC + 1;
                } else {
                    highC = midC - 1;
                }
            }
            break;
        } else if(matrix[mid][0] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
     } 
      return Boolean.FALSE;
    }
}
