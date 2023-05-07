//37. Sudoku Solver
//https://leetcode.com/problems/sudoku-solver/


class Solution {
    public void solveSudoku(char[][] board) {
        rec(board, 0, 0);
    }

    public boolean rec(char[][] board, int r, int c){
        int[] next = nextRC(r,c);
        if(r == 9){
            return true;
        }
        if(board[r][c] != '.'){
            return rec(board, next[0], next[1]);
        }
        for(int i=1;i<=9;i++){
            if(board[r][c] == '.'){
                if(isNumberFit(board, i, r, c)){
                    board[r][c] = (char)(i+'0');
                    boolean res = rec(board, next[0], next[1]);
                    if(!res){
                        board[r][c] = '.';
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int[] nextRC(int r, int c){
        int[] res = new int[2];
        res[0] = c < 8 ? r : r+1;
        res[1] = c < 8 ? c+1 : 0;
        return res;
    }
    public boolean isNumberFit(char[][] board, int num, int row, int col){
        return searchRow(board, num, row) && searchCol(board, num, col) && searchGrid(board, num, row, col);
    }
    public boolean searchCol(char[][] board, int num, int col){
        for(int j=0; j<9; j++){
            if(board[j][col] != '.'){
                int bnum = Character.getNumericValue(board[j][col]);
                if(bnum == num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean searchRow(char[][] board, int num, int row){
        for(int j=0; j<9; j++){
            if(board[row][j] != '.'){
                int bnum = Character.getNumericValue(board[row][j]);
                if(bnum == num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean searchGrid(char[][] board, int num, int r1, int c1){
        int row = 3*(r1/3);
        int col = 3*(c1/3);
        for(int i=row; i<row+3; i++){
            for(int j=col; j<col+3; j++){
                if(board[i][j] != '.'){
                    int bnum = Character.getNumericValue(board[i][j]);
                    if(bnum == num){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
