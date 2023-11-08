package com.study.codingtest.programmers.books.ch11;

import java.util.Stack;

public class _12909 {

    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c=='(')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;

                if(stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
