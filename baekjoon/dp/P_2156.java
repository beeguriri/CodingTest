package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
포도주 시식
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 */
public class P_2156 {

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
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+board[i-1], dp[i-2])+board[i]);

        System.out.println(dp[n]);
    }
}
