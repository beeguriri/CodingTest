package com.study.codingtest.programmers.level1;

//스택으로 풀기

import java.util.Stack;

public class P_03 {

    static int calcNum(char c, int num) {

        if(c=='S')
            return num;
        else if(c=='D')
            return num*num;
        else
            return num*num*num;

    }

    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        //연산결과를 스택에 넣고 빼서 마지막에 일괄 계산 하자!
        int lastIdx = 0;
        for(int i=0; i<dartResult.length(); i++) {

            char c = dartResult.charAt(i);
            if((c=='S' || c=='D' || c=='T')) {
                int x = Integer.parseInt(dartResult.substring(lastIdx, i));
                lastIdx = i+1;

                stack.push(calcNum(c, x));

            }  else if ((c=='*' || c=='#')) {
                if(c=='*') {
                    if(!stack.isEmpty()) {
                        if(stack.size()==1)
                            stack.push(stack.pop()*2);
                        else if(stack.size() >=2) {
                            int a = stack.pop()*2;
                            int b = stack.pop()*2;
                            stack.push(b);
                            stack.push(a);
                        }
                    }
                } else {
                    if(!stack.isEmpty())
                        stack.push(stack.pop()*-1);
                }
                lastIdx = i+1;
            }
        }

        while(!stack.isEmpty())
            answer += stack.pop();

        return answer;
    }
}
