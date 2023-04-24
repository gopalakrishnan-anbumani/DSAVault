//66. Plus One
//https://leetcode.com/problems/plus-one/description/


class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int add = digits[digits.length-1] + 1;
        if(add > 9){
            carry = 1;
            result.add(0,0);
        } else {
            result.add(0,add);
        }
        for(int i = digits.length-2; i >= 0; i--){
            int num = digits[i] + carry;
            carry = 0;
            if(num > 9){
                carry = 1;
                num = 0;
            }
            result.add(0,num);
        }
        if(carry==1) result.add(0,1);
        return result.stream().mapToInt(Integer::intValue)
                              .toArray();
    }
}
