package com.study.codingtest.programmers.level2;

import java.util.*;
/*
주식 가격
 */
public class P_36 {

    public int[] solution(int[] prices) {

        int[] answer = new int [prices.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {

            while(!stack.isEmpty() && prices[i]<prices[stack.peek()])
                answer[stack.peek()] = i-stack.pop();

            stack.push(i);

        }

        while(!stack.isEmpty())
            answer[stack.peek()] = prices.length-1-stack.pop();

        // System.out.println(stack);
        // System.out.println(Arrays.toString(answer));

        return answer;
    }
}
