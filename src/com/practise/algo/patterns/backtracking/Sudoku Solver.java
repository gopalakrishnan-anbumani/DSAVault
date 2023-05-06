//37. Sudoku Solver
//https://leetcode.com/problems/sudoku-solver/


class Solution {
    HashMap<Integer, HashSet<Integer>> grid = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
    char[][] board1 = new char[9][9];
    public void solveSudoku(char[][] board) {
        rec(board, 0, 0);
        //System.out.println(col);
             for(char[] b : board1){
                System.out.println(Arrays.toString(b));                  
            }
        board = board1;
    }

    public boolean rec(char[][] board, int r, int c){
        //System.out.println(r+" "+c);
        boolean isDefault= false;
        int[] next = nextRC(r,c);
        if(next[0] == 9){

            board1 = board.clone();

            return true;
        }
        if(board[r][c] != '.'){
            isDefault = true;
            rec(board, next[0], next[1]);
        }
        boolean isNumSet= false;
        for(int i=1;i<=9;i++){
            if(board[r][c] == '.'){
                if(isNumberFit(board, i, r, c)){
                    isNumSet = true;
                    //System.out.println(r+" "+c+ " setting val "+ i);
                    board[r][c] = (char)(i+'0');
                    boolean res = rec(board, next[0], next[1]);
                    if(!res){
                       //System.out.println(r+" "+c+ " resett val "+ i);
                        board[r][c] = '.';
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isNumberSet(char[][] board, int r, int c, int num){
        int gridNum = (3*(r/3)) + (c/3);
        HashSet<Integer> gridSec = grid.get(gridNum);

        return true;
    }
    public int[] nextRC(int r, int c){
        int[] res = new int[2];
        res[0] = c < 8 ? r : r+1;
        res[1] = c < 8 ? c+1 : 0;
        return res;
    }
    public void section(char[][] board){
        int count = 0;
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                HashSet<Integer> gridNums = new HashSet<>();
                for(int r=0; r<3; r++){
                    for(int c=0; c<3; c++){
                        if(board[r+i][c+j] != '.'){
                            gridNums.add(Character.getNumericValue(board[r+i][c+j]));
                        }
                    }
                }
                grid.put(count, gridNums);
                count++;
            }
        }
    }
    public void row(char[][] board){
        int count = 0;
        for(int i=0; i<9; i++){
            HashSet<Integer> rowNums = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    rowNums.add(Character.getNumericValue(board[i][j]));
                }
            }
            row.put(count, rowNums);
            count++;
        }
        System.out.println(row);
    }
    public void col(char[][] board){
        int count = 0;
        for(int i=0; i<9; i++){
            HashSet<Integer> colNums = new HashSet<>();
            for(int j=0; j<9; j++){
                if(board[j][i] != '.'){
                    colNums.add(Character.getNumericValue(board[j][i]));
                }
            }
            row.put(count, colNums);
            count++;
        }
        System.out.println(row);
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
                //System.out.println(i+ " "+j +" ");
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
