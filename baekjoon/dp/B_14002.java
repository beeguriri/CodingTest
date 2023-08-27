package com.study.codingtest.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_14002 {

    /*
    가장 긴 증가하는 부분 수열 4
    첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
    둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] numbers = new int [n];
        int [] dp = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxLen = 0;

        for(int i=0; i<n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++)
                if (numbers[j] < numbers[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            maxLen = Math.max(dp[i], maxLen);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append("\n");

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            if(dp[i]==maxLen){
                stack.push(numbers[i]);
                maxLen--;
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        System.out.println(sb);

    }
}
