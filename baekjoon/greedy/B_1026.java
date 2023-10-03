package com.study.codingtest.baekjoon.greedy;

/*
보물
S = A[0] × B[0] + ... + A[N-1] × B[N-1] 최소값
A는 최대값, B는 최소값으로 곱하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1026 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            listA.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            listB.add(Integer.parseInt(st.nextToken()));

        //A는 오름차순 정렬
        //B는 내림차순 정렬
        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());

        //계산
        int sum = 0;
        for(int i=0; i<n; i++)
            sum+=listA.get(i)*listB.get(i);


        System.out.println(sum);
    }
}
