package com.study.codingtest.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class B_24511 {

    //queuestack
    // que stack stack que
    // 1    2    3     4
    //2를 삽입하면
    // 2    2  3       1
    //4를 삽입하면
    // 4   2   3      4 ...

    public static void main(String[] args) throws IOException {

        //queueStack에서 queue인것만 새로 입력되는 숫자로 갱신해 주면 되잖아
        //그리고 정답은 큐에서 나온 원소...?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] queueStack = br.readLine().split(" ");
        String [] result = br.readLine().split(" ");

        //큐인 원소만 차례대로 넣어서 초기화
        //수열 추가할 때는 뒤에서 빼서 정답에 기록하고, 수열은 앞으로 넣어주기
        Deque<String> deque = new LinkedList<>();
        for(int i=0; i<n; i++)
            if(queueStack[i].equals("0"))
                deque.addLast(result[i]);

        int m = Integer.parseInt(br.readLine());
        String [] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        if(deque.isEmpty()) {
            for(String s : str)
                sb.append(s).append(" ");
        } else {
            for (int i = 0; i < m; i++) {
                sb.append(deque.pollLast()).append(" ");
                deque.addFirst(str[i]);
            }
        }

        System.out.println(sb);
    }
}
