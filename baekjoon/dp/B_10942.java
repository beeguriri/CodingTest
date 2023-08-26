package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10942 {

    //1<=s<=e
    //자연수 n
    //질문 m
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] numbers = new int [n+1];
        int [][] dp = new int [n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int [][] questions = new int [m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
        }

        //길이 1일때 초기화
        for(int i=1; i<=n; i++)
            dp[i][i] = 1;

        //길이 2일때는 같은지 확인
        for(int i=1; i<n; i++)
            if(numbers[i] == numbers[i+1])
                dp[i][i+1] = 1;


        //길이가 3이상 일때는 양끝 숫자가 같은지 확인 하고
        //같으면 dp[s+1][e-1]이 팰린드롬인지 확인 (대각선 아래방향)
        for(int i=n-2; i>=1; i--)
            for(int j=n; j>=i+2; j--)
                if(numbers[i]==numbers[j] && dp[i+1][j-1]==1)
                    dp[i][j] = 1;

        for(int [] i : dp)
            System.out.println(Arrays.toString(i));

        StringBuilder sb = new StringBuilder();
        for(int [] q : questions)
            sb.append(dp[q[0]][q[1]]).append("\n");

        System.out.print(sb);
    }
}
