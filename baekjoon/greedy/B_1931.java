package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] times = new int [n][2];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            times[i][0] = Integer.parseInt(s.split(" ")[0]);
            times[i][1] = Integer.parseInt(s.split(" ")[1]);
        }

        //끝나는 시간 기준 정렬
        Arrays.sort(times, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int target = times[0][1];
        int count = 1;
        for(int i=1; i<n; i++) {
            if(times[i][0]>=target){
                count++;
                target = times[i][1];
            }
        }

        System.out.println(count);

    }
}
