package com.study.codingtest.books.ch12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _42883_1 {

    public String solution(String number, int k) {

        //스택과 큐로 풀기?
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> num = new LinkedList<>();

        for(int i=0; i<number.length(); i++)
            num.offer(Integer.parseInt(number.substring(i, i+1)));

        while(!num.isEmpty()) {

            if(stack.isEmpty()){
                stack.push(num.poll());
                continue;
            }

            if(stack.peek()>=num.peek())
                stack.push(num.poll());

            else {
                int count = 0;
                while(!stack.isEmpty() && count<k && stack.peek()<num.peek()){
                    stack.pop();
                    count++;
                }
                stack.push(num.poll());
                k -= count;
            }

            if(k==0)
                break;

            if(stack.size() == number.length()-k)
                break;

        }

        String answer = "";

        // System.out.println(">>stack: " + stack);
        // System.out.println(">>array: " + num);

        //남은거 다 넣어주기
        StringBuilder sb = new StringBuilder();

        while(!num.isEmpty() && stack.size()<number.length()-k)
            stack.push(num.poll());

        while(!stack.isEmpty())
            sb.insert(0, stack.pop());

        answer = sb.toString();

        return answer;

    }
}
