//https://leetcode.com/problems/kth-missing-positive-number/description/
//Random
//1539. Kth Missing Positive Number

class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int currentNumber = 1;
        int i = 0;
        int missed = 0;
        while(i <= 1000){
            if(i < arr.length && arr[i] == currentNumber){
                currentNumber += 1;
                i++;
            } else {
                currentNumber += 1;
                missed++;
            }
            if(missed == k){
                return currentNumber-1;
            }
        }
        return 0;
    }
}
