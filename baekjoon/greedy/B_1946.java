package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
신입 사원
서류심사 성적과 면접시험 성적 중
적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
[서류 순위, 면접 순위]
=> 서류 순위로 오름차순 정렬
=> 1번째부터 앞사람 순위보다 작은 숫자만 선발
 */
public class B_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        for(int t=0; t<tCase; t++){

            int n= Integer.parseInt(br.readLine());
            int [][] ranks = new int [n][2];
            for(int i=0; i<n; i++){
                String [] temp = br.readLine().split(" ");
                ranks[i][0] = Integer.parseInt(temp[0]);
                ranks[i][1] = Integer.parseInt(temp[1]);
            }

            //서류 순위 오름차순으로 정렬
            Arrays.sort(ranks, (o1, o2) -> o1[0] - o2[0]);
            int count = 1;
            int last = ranks[0][1];

            for(int i=1; i<n; i++){
                if(ranks[i][1]<last){
                    count++;
                    last = ranks[i][1];
                }
            }
            System.out.println(count);
        }

    }
}
