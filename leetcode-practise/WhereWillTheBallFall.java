//1706. Where Will the Ball Fall
//https://leetcode.com/problems/where-will-the-ball-fall/description/

class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] res = new int[n];

        for(int i=0; i<n; i++){
            int r = 0;
            int c = i;
            int ans = -1;
            while(r<m){
                int diagonal = grid[r][c];
                if(c == 0 && diagonal == -1){
                    break;
                }
                if(c == n-1 && diagonal == 1){
                    break;
                }
                if(diagonal == 1 && grid[r][c+1] == -1){
                    break;
                }
                if(diagonal == -1 && grid[r][c-1] == 1){
                    break;
                }
                if(diagonal == 1){
                    c = c+1;
                } else {
                    c = c-1;
                }
                if(r == m-1){
                    ans = c;
                    break;
                }
                r = r+1;
            }
            res[i] = ans;
        }
        return res;
    }
}