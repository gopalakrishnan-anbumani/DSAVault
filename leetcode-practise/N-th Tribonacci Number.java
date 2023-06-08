//1137. N-th Tribonacci Number
//https://leetcode.com/problems/n-th-tribonacci-number/description/

class Solution {
    public int tribonacci(int n) {
        if(n<=0){
            return 0;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i=3; i<=n; i++){
            int temp = c;
            c = a + b + c;
            a = b;
            b = temp;
        }
        return c;
    }
}
