package com.study.codingtest.books.ch10;

public class _12945 {

    static final int MOD = 1234567;
    public int solution(int n) {

        int [] dp = new int [n+1];

        //n이 2이상이므로
        dp[1] = 1;

        for(int i=2; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2])%MOD;

        return dp[n];
    }
}