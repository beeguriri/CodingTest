package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
RGB거리
내 윗행의 최소값
 */
public class B_1149 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] board = new int [n+1][3];
        int [][] dp = new int [n+1][3];

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            dp[i][0] = board[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = board[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = board[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        //최소값 찾기
        int min = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(min);

    }
}
