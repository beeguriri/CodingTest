package com.study.codingtest.programmers.level2;

import java.util.*;

public class P_04 {
    /*
    짝지어 제거 하기
     */
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {

            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            char target = s.charAt(i);

            if(stack.peek()==target)
                stack.pop();
            else
                stack.push(target);

        }

        return stack.isEmpty() ? 1 : 0;
    }
}
