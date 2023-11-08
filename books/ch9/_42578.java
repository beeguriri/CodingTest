package com.study.codingtest.books.ch9;

import java.util.HashMap;
import java.util.Map;

public class _42578 {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for(String [] clothe : clothes)
            map.put(clothe[1], map.getOrDefault(clothe[1], 0)+1);

        // System.out.println(map);

        for(String key : map.keySet())
            answer *= (map.get(key)+1);

        return answer-1;
    }
}
