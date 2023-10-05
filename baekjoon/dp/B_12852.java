package com.study.codingtest.baekjoon.dp;

import java.util.Scanner;

/*
1로 만들기 2
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
첫째줄에 최소횟수
둘째줄에 거쳐온 경로
 */
public class B_12852 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] dp = new int [n+1];
        int [] result = new int [n+1];

        for(int i=2; i<=n; i++){

            dp[i] = dp[i-1]+1;
            result[i] = i-1;

            //갱신할때만 기록해줄꺼니까
            if(i%3==0 && dp[i/3]+1<dp[i]){
                dp[i] = dp[i/3]+1;
                result[i] = i/3;
            }

            if(i%2==0 && dp[i/2]+1<dp[i]){
                dp[i] = dp[i/2]+1;
                result[i] = i/2;
            }
        }

        System.out.println(dp[n]);

        //경로 찾기
        int index = n;
        StringBuilder sb = new StringBuilder();

        while(index>0){
            sb.append(index).append(" ");
            index = result[index];
        }

        System.out.println(sb);

    }
}
