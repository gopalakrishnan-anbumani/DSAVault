// N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, Find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times. 
// Note: 0 represents the bulb is off and 1 represents the bulb is on. 

class MinBulbSwitch
{
    public static int countFlips(int a[], int n)
    {
        int count = 0;
        for(int state : a){
            if(count % 2 != 0){
                state = 1 - state;
            }
            if(state == 0){
                count++;
            }
        }
        return count;
    }
}


// https://www.geeksforgeeks.org/count-minimum-right-flips-to-set-all-values-in-an-array/
// Free Code camp - Greedy Algorithm Video - [https://www.youtube.com/watch?v=bC7o8P_Ste4&t=536s]
