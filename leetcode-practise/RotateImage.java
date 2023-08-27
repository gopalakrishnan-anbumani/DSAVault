//48. Rotate Image
//https://leetcode.com/problems/rotate-image/description/

public class RotateImage
{
    public void rotate(int[][] m) {

        int R = 0;
        int C = m[0].length-1;

        while(R<C){
            int i = 0;
            while(R+i<C){
                //1st Ele 
                int temp = m[R][R+i];
                m[R][R+i] = m[C-i][R];  //4th Element
                m[C-i][R] = m[C][C-i];//3rd Element
                m[C][C-i] = m[R+i][C];//2nd Element
                m[R+i][C] = temp;
                i++;
            }
            R++;
            C--;
        }
    }
}