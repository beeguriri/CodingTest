package com.study.codingtest.programmers.level2;

import java.util.Stack;

public class P_12 {

    static boolean isPossible(char[] array) {

        Stack<Character> stack = new Stack<>();

        for(char c : array) {

            if(c=='[' || c=='(' || c=='{')
                stack.push(c);
            else if(c==']' && !stack.isEmpty() && stack.peek()=='[')
                stack.pop();
            else if(c==')' && !stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{')
                stack.pop();
            else
                stack.push(c);

        }

        return stack.isEmpty();
    }


    public static int solution(String s) {
        int answer = 0;
        //s 길이만큼 순회 할건데
        //시작을 0부터 헤서 %length => for 두개
        int n = s.length();
        char [] sArr;

        for(int i=0; i<n; i++) {
            sArr = new char[n];
            int idx = 0;
            for(int j=i; j<i+n; j++)
                sArr[idx++] = s.charAt(j%n);

            // System.out.println(Arrays.toString(sArr));

            //올바른 괄호 확인
            if(isPossible(sArr))
                answer++;

        }

        return answer;
    }
}
