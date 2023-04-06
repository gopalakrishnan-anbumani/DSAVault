//1254. Number of Closed Islands
//https://leetcode.com/problems/number-of-closed-islands/description/

class Solution {
    int ROWS = 0;
    int COLS = 0;
    Set<String> visit = new HashSet<>();
    public int closedIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int result = 0;
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j] == 0 && !visit.contains(i+""+j)){
                    result += dfs(i,j,grid);
                }
            }
        }
        return result;
    }

    public int dfs(int r, int c, int[][] grid){
        if(r < 0 || c < 0 || r == ROWS || c == COLS){
            return 0;
        }
        if(grid[r][c] == 1 || visit.contains(r+""+c)){
            return 1;
        }
        visit.add(r+""+c);
        
        return Math.min(
            Math.min(
                Math.min(dfs(r+1, c, grid),dfs(r-1, c, grid)), dfs(r, c+1, grid)
            ), dfs(r, c-1, grid)
        );

    }
}
