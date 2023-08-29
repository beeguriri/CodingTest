package com.study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B_1302 {

    /*
    베스트셀러
    //map으로 횟수 저장하고, 값 꺼내면 되지 않을까?
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        ArrayList<String> temp = new ArrayList<>(map.keySet());
        temp.sort((o1, o2) -> map.get(o2) == map.get(o1) ? o1.compareTo(o2) : map.get(o2) - map.get(o1));

        System.out.println(temp.get(0));
    }
}
