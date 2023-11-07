package com.study.codingtest.programmers.books.ch9;

import java.util.HashSet;
import java.util.Set;

public class _86051 {

    public int solution(int[] numbers) {

        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int i : numbers)
            set.add(i);

        for(int i=0; i<=9; i++){
            if(!set.contains(i))
                answer += i;
        }

        return answer;
    }
}
