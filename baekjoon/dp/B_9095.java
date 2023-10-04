package com.study.codingtest.baekjoon.dp;

import java.util.Scanner;

/*
1,2,3더하기
n은 양수이며 11보다 작다.
//n=1 => 1가지
//n=2 => 2가지
//n=3 => 4가지
//n=4 => 1+2+4 => 7
//n=5 => 2+4+7 => 13
//n=6 => 4+7+13 => 24
//n=7 ==> 7+13+24 = 44
 */
public class B_9095 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int [] dp = new int [11];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=10; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        for(int i=0; i<c; i++)
            System.out.println(dp[sc.nextInt()]);

    }
}
