package com.study.codingtest.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_12789 {

    /**
     * 도키도키 간식드리미
     * Stack, Queue
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); //최초 입력
        Stack<Integer> stack = new Stack<>(); //대기열

        for(int i=0; i<n; i++)
            queue.offer(Integer.parseInt(st.nextToken()));

        int now = 1; //번부터 n번까지 돌기
        while(!queue.isEmpty()) {

            //현재순서와 queue에서 뽑을 수 있는 값이 같으면
            if(queue.peek()==now){
                now++;
                queue.poll();
                continue;
            }

            //현재순서와 stack에서 뽑을 수 있는 값이 같으면
            if(!stack.isEmpty() && stack.peek()==now){
                now++;
                stack.pop();
                continue;
            }

            stack.push(queue.poll());
        }

        //추가 대기열에 있던 거 한번 더 확인
        while(!stack.isEmpty()){
            if(stack.peek()==now){
                now++;
                stack.pop();
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
    }
}
