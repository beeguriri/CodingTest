package com.study.codingtest.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9613 {

    //10 20 30 40
    //(10,20) => 10, (10, 30) => 10, (10, 40) => 10
    //(20, 30) => 10, (20, 40) => 20
    //(30, 40) => 10

    static int gcd(int x, int y){
        if(y==0)
            return x;
        return gcd(y, x%y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int [] arr = new int [m];
            long answer = 0;

            for(int j=0; j<m; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            for(int j=0; j<m-1; j++){
                for(int k=j+1; k<m; k++) {
                    answer += gcd(arr[j], arr[k]);
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
