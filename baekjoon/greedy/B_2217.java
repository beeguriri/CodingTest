package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
로프
무게를 내림차순 정렬
해당무게 * (i+1) => 로프로 들수 있는 최대 무게
 */
public class B_2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));

        int max = 0;

        list.sort(Collections.reverseOrder());

        for (int i = 0; i < n; i++)
            max = Math.max(max, list.get(i) * (i + 1));

        System.out.println(max);

    }
}
