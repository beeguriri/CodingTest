package com.study.codingtest.programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P_14 {

    static boolean isPossible(Map<String, Integer> map, String [] want, int [] number) {

        for(int i=0; i<want.length; i++){
            if(!map.containsKey(want[i]))
                return false;

            if(map.get(want[i])!=number[i])
                return false;
        }

        return true;

    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //매번 map을 만들어서 갯수를 샐까?
        Map<String, Integer> map;

        for(int i=0; i<=discount.length-10; i++) {

            map = new HashMap<>();
            for(int j=i; j<i+10; j++)
                map.put(discount[j], map.getOrDefault(discount[j], 0) + 1);

            // System.out.println(map);
            if(isPossible(map, want, number))
                answer++;

        }

        return answer;
    }
}
