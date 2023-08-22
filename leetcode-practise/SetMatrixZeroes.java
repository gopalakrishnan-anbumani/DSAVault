//73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/description/

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowClean = false;
        boolean colClean = false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                rowClean = true;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                colClean = true;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowClean){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        if(colClean){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
    }


}