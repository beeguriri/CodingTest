package com.study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B_3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                if(stack.peek()==c)
                    stack.pop();
                else
                    stack.push(c);
            }
            if(stack.isEmpty())
                count++;
        }

        System.out.println(count);
    }
}
