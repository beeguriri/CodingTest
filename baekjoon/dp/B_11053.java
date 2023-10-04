package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 긴 증가 하는 부분 수열
 */
public class B_11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] board = new int [n];
        int [] dp = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            board[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++)
                if(board[i]>board[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
        }

        System.out.println(dp[n-1]);
    }
}
