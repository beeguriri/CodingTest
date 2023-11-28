package com.study.codingtest.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2167 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //입력
        int [][] array = new int [m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        //출력
        StringBuilder sb = new StringBuilder();
        for(int cnt=0; cnt<k; cnt++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int sum = 0;
            for(int row=i; row<=x; row++){
                for(int col=j; col<=y; col++){
                    sum += array[row][col];
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.print(sb);


    }
}
