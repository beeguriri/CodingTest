package com.study.codingtest.programmers.books.ch9;

import java.util.HashSet;
import java.util.Set;

public class _120888 {

    public String solution(String my_string) {

        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();

        //set에 문자 다 넣어놓고, 있으면 continue;
        for(char c : my_string.toCharArray()){
            if(set.contains(c))
                continue;

            set.add(c);
            sb.append(c);
        }

        return sb.toString();
    }
}
