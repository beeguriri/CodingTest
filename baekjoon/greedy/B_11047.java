package com.study.codingtest.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int target = Integer.parseInt(s.split(" ")[1]);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++)
            list.add(Integer.parseInt(br.readLine()));

        list.sort(Collections.reverseOrder());

        int sum = 0;
        for(int i : list){
            sum += target/i;
            target %= i;
        }

        System.out.println(sum);
    }
}
