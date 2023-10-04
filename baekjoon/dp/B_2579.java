package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
계단 오르기
계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다.
즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
마지막 도착 계단은 반드시 밟아야 한다.
//3번째 앞칸의 기록된 값 + 1번째 앞칸의 계단값
//2번째 앞칸의 기록된 값
 */

public class B_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] board = new int [n+1];
        int [] dp = new int [n+1];
        for(int i=1; i<=n; i++)
            board[i] = Integer.parseInt(br.readLine());

        dp[1] = board[1];
        if(n>=2) dp[2] = board[1] + board[2];

        for(int i=3; i<=n; i++)
            dp[i] = Math.max(dp[i-3]+board[i-1], dp[i-2]) + board[i];

        System.out.println(dp[n]);

    }
}
