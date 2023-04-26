//51. N-Queens
//https://leetcode.com/problems/n-queens/description/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> solutions = new ArrayList<> (Collections.nCopies(n,-1));
        List<List<Integer>> results = new ArrayList<>();
        solveNQueensRec(n, 0, solutions, results);
        List<List<String>> finalRes = new ArrayList<>();
        System.out.println(results);
        for(List<Integer> result: results){
            List<String> str = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder strBuilder = new StringBuilder();
                int col = result.get(i);
                for(int row=0;row<n;row++){
                    if(row==col){
                        strBuilder.append("Q");
                    } else {
                        strBuilder.append(".");
                    }
                }
                str.add(strBuilder.toString());
            }
            finalRes.add(str);
        }
        return finalRes;
    }

    public void solveNQueensRec(int n, int row, List<Integer> solutions, List<List<Integer>> result){
        if(n == row){
            result.add(new ArrayList<>(solutions));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(row, col, solutions)){
                solutions.set(row,col);
                solveNQueensRec(n, row+1, solutions, result);
            }
        }
    }

    public boolean isValid(int proposedRow, int proposedCol, List<Integer> solutions) {
        int oldRow = 0, oldCol = 0, diagonalOffset = 0;
        for(int i=0; i < proposedRow; i++){
            oldRow = i;
            oldCol = solutions.get(i);
            diagonalOffset = proposedRow - oldRow;
            if(oldCol == proposedCol || oldCol == proposedCol - diagonalOffset 
            || oldCol == proposedCol + diagonalOffset || oldRow == proposedRow){
                return false;
            }
        }
        return true;
    }
}
