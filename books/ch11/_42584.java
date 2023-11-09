package com.study.codingtest.books.ch11;

import java.util.Stack;

public class _42584 {

    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        //현재 기준 스택을 봤을 때
        //나보다 작거나 같으면 가격이 떨어지지 않음
        //나보다 크면 가격이 떨어졌음
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length; i++) {

            while(!stack.isEmpty() && prices[stack.peek()]>prices[i])
                answer[stack.peek()] = i - stack.pop();

            stack.push(i);
        }

        while(!stack.isEmpty())
            answer[stack.peek()] = prices.length - 1 - stack.pop();

        return answer;
    }
}
