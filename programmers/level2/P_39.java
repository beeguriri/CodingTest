package com.study.codingtest.programmers.level2;

import java.util.*;
/*
롤케이크 자르기
동생은 set에 넣고
map에서 배열 한칸 지날때마다 토핑갯수 삭제
남은 것이 없다면 키 삭제
동생 set size == map size 이면 공평하게 나눈 것!
 */
public class P_39 {
    public int solution(int[] topping) {

        Set<Integer> getTopping = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;

        for(int i : topping)
            map.put(i, map.getOrDefault(i, 0)+1);

        // System.out.println(map);

        for(int i : topping) {

            getTopping.add(i);

            if(map.get(i)>=2)
                map.put(i,map.get(i)-1);
            else
                map.remove(i);

            if(getTopping.size() == map.size())
                answer++;
        }

        return answer;
    }
}
