package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
카드 정렬하기
합친 값 => 다음 카드랑 계속 합쳐주기
작은 숫자들을 합쳐나가야하므로 우선순위 큐
큐의 사이즈가 1이 될때까지
 (1 ≤ N ≤ 100,000) 반복 할 수 있으므로 long type
 */
public class B_1715 {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
            pq.offer(Long.parseLong(br.readLine()));

        long sum = 0;
        while(pq.size()>1){
            long a = pq.poll();
            long b = pq.poll();
            sum += (a+b);
            pq.offer(a+b);
        }

        System.out.println(sum);
    }
}
