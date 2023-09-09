package com.study.codingtest.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class P_09 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];

        //키 저장
        Map<String, Integer> map = new HashMap<>();

        for(String s : keymap) {

            for(int i=0; i<s.length(); i++) {

                String key = s.substring(i, i+1);

                if(map.containsKey(key))
                    map.put(key, Math.min(map.get(key), i+1));
                else
                    map.put(key, i+1);

            }
        }

        //키에서 값 계산
        for(int i=0; i<targets.length; i++) {
            int count = 0;
            for(int j=0; j<targets[i].length(); j++) {
                String key = targets[i].substring(j, j+1);

                if(!map.containsKey(key)) {
                    count = -1;
                    break;
                }
                else
                    count += map.get(key);
            }
            answer[i] = count;
        }

        return answer;
    }
}
