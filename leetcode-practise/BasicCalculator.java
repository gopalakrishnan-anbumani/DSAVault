//224. Basic Calculator
//https://leetcode.com/problems/basic-calculator/description/

import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            String val = s.charAt(i) + "";

            if(val.equals("+")){
                stack.push(val);
            } else if(val.equals("-")){
                stack.push(val);
            } else if(val.equals("(")){
                stack.push("(");
            } else if(val.equals(")")){
                boolean isFlag = true;
                int total = 0;
                int toAdd = 0;
                while(isFlag){
                    String popVal = stack.pop();
                    try {
                        toAdd += Integer.parseInt(popVal);
                    } catch(NumberFormatException e){
                        if(popVal.equals("(")){
                            if(!stack.isEmpty()){
                                String last = stack.pop();
                                if(last.equals("-")){
                                    stack.push(String.valueOf(-1*toAdd));
                                } else {
                                    stack.push(last);
                                    stack.push(String.valueOf(toAdd));
                                }
                            } else {
                                stack.push(String.valueOf(toAdd));
                            }

                            isFlag = false;
                        } else {

                        }
                    }
                }
            } else if(val.equals(" ")){

            } else { //Number
                int num = Integer.valueOf(val);
                if(!stack.isEmpty()){
                    String popVal = stack.pop();
                    try {
                        int preVal = Integer.parseInt(popVal);
                        if(preVal >= 0){
                            num = (preVal * 10) + num;
                        } else {
                            num = (preVal * 10) - num;
                        }

                        stack.push(String.valueOf(num));
                    } catch(NumberFormatException e){
                        if(popVal.equals("-")){
                            num = -1 * num;
                            stack.push("+");
                            stack.push(String.valueOf(num));
                        } else {
                            stack.push(popVal);
                            stack.push(val);
                        }
                    }
                } else {
                    stack.push(val);
                }
            }
        }
        int res = 0;

        while(!stack.isEmpty()){
            String val = stack.pop();
            try {
                res += Integer.parseInt(val);
            } catch(NumberFormatException e){

            }
        }
        return res;
    }
}