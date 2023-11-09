package com.study.codingtest.books.ch9;

import java.util.HashMap;
import java.util.Map;

public class _42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        //동명이인 있을 수 있다고 했으므로 set은 못쓰고.. map에 넣은 후
        //completion에 있을때마다 key 삭제
        Map<String, Integer> map = new HashMap<>();

        for(String key : participant)
            map.put(key, map.getOrDefault(key, 0)+1);


        for(String key : completion){
            if(map.get(key)>=2)
                map.put(key, map.get(key)-1);
            else if(map.get(key)==1)
                map.remove(key);
        }

        for(String key : map.keySet())
            answer = key;

        return answer;
    }
}
