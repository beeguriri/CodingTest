package com.study.codingtest.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P_17 {

    public int solution(String[][] clothes) {
        int answer = 1;

        //의상의 종류를 카운트 해서
        //종류 별 조합갯수 구하기
        Map<String, Integer> map = new HashMap<>();

        for(String [] cl : clothes)
            map.put(cl[1], map.getOrDefault(cl[1], 0) + 1);

        System.out.println(map);

        //0개일때 포함
        for(int i : map.values())
            answer *= (i+1);

        //모두 0인 경우 빼주기
        return answer-1;
    }
}
