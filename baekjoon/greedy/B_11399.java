package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] num = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);
        int [] result = new int [n];
        result[0] = num[0];
        for(int i=1; i<n; i++)
            result[i] = result[i-1]+num[i];

        int sum = 0;
        for(int i : result)
            sum += i;

        System.out.println(sum);
    }
}
