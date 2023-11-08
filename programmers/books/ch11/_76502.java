package com.study.codingtest.programmers.books.ch11;

import java.util.Stack;

public class _76502 {

    static boolean isPossible(char [] array) {

        Stack<Character> stack = new Stack<>();

        for(char c : array){

            if(c=='(' || c=='[' || c=='{')
                stack.push(c);

            else {
                if(stack.isEmpty())
                    return false;

                if(c==']' && stack.peek()=='[')
                    stack.pop();
                else if(c==')' && stack.peek()=='(')
                    stack.pop();
                else if(c=='}' && stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public int solution(String s) {

        char [] temp = s.toCharArray();
        int answer = 0;

        for(int i=0; i<s.length(); i++){

            //새로운 괄호 배열 만들기
            int idx=0;
            char [] newArray = new char [temp.length];

            for(int j=i; j<i+s.length(); j++)
                newArray[idx++] = temp[j%s.length()];

            //확인
            // System.out.println(Arrays.toString(newArray));
            if(isPossible(newArray))
                answer++;
        }

        return answer;
    }
}
