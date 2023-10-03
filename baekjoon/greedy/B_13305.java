package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
주유소
i+1번째에서
거쳐온 길에서 최소값을 찾아서
그값과 거리 곱해주기
최소값 갱신되면 새로운 값으로 곱해주기
//cost의 제일 마지막 항목이 필요가 없구낭
거리는 1이상 1,000,000,000 이하의 자연수
리터당 가격은 1 이상 1,000,000,000 이하의 자연수
=> 계산결과를 long type으로 선언해주기
 */
public class B_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] dist = new int [n-1];
        int [] cost = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++)
            dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            cost[i] = Integer.parseInt(st.nextToken());

        long minCost = cost[0];
        long sum = 0;
        for(int i=0; i<n-1; i++){
            minCost = Math.min(minCost, cost[i]);
            sum += minCost*dist[i];
        }

        System.out.println(sum);
    }
}
