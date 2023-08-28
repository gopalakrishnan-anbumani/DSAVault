//54. Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/description/

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> result = new ArrayList<>();
        int R = m.length;
        int C = m[0].length;

        int s = 0;
        int row = 0;
        int col = -1;
        int direction = 1;
        while(R>0 && C>0){

            for(int i=0; i<C; i++){
                col += direction;
                result.add(m[row][col]);
            }
            R--;
            for(int i=0; i<R; i++){
                row += direction;
                result.add(m[row][col]);
            }

            C--;
            direction *= -1;
        }
        return result;
    }
}