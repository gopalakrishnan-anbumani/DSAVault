//2038.Remove-colored-pieces-if-both-neighbors-are-the-same-color
//https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/description/

class RemoveSameColor {
    public boolean winnerOfGame(String colors) {
        int Amove = 0;
        int Bmove = 0;

        int count = 0;
        int bount = 0;
        for(char ch : colors.toCharArray()){
            if(ch == 'A'){
                count++;
            } else {
                if(count >= 3){
                    Amove += count-2;
                }
                count = 0;
            }

            if(ch == 'B'){
                bount++;
            } else {
                if(bount >= 3){
                    Bmove += bount-2;
                }
                bount = 0;
            }
        }
        if(bount>=3){
            Bmove += bount-2;
        }
        if(count >= 3){
            Amove += count-2;
        }
        //System.out.println(Amove + "---" + Bmove);
        if(Amove > Bmove){
            return true;
        } else {
            return false;
        }
    }
}