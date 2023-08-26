package com.study.codingtest.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class B_11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 10_007;

        long [][] dp = new long [n+1][10];

        Arrays.fill(dp[0], 1);

        for(int i=1; i<=n; i++) {
            dp[i][9] = 1;
            for(int j=8; j>=0; j--) {
                dp[i][j] += dp[i-1][j] + dp[i][j+1];
                dp[i][j] %= mod;
            }

        }

        System.out.println(Arrays.toString(dp[n]));
        System.out.println(dp[n][0]);

    }
}
