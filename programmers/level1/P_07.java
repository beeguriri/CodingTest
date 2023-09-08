package com.study.codingtest.programmers.level1;

import java.util.*;

public class P_07 {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for(String s : participant)
            map.put(s, map.getOrDefault(s, 0) + 1);

        for(String s : completion) {
            if(map.containsKey(s) && map.get(s)>=1) {

                if(map.get(s)==1)
                    map.remove(s);

                else
                    map.put(s, map.get(s)-1);
            }
        }

        // System.out.println(map);

        List<String> answer = new ArrayList<>(map.keySet());
        return answer.get(0);

    }

    //시간초과
    public String solution1(String[] participant, String[] completion) {

        List<String> part = new ArrayList<>(Arrays.asList(participant));
        List<String> comp = new ArrayList<>(Arrays.asList(completion));

        for(String s : comp)
            part.remove(s);

        return part.get(0);
    }
}
