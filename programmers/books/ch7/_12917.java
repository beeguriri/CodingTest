package com.study.codingtest.programmers.books.ch7;

import java.util.Arrays;

public class _12917 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String [] temp = s.split("");
        Arrays.sort(temp);

        for(int i=temp.length-1; i>=0; i--)
            sb.append(temp[i]);

        return sb.toString();
    }
}
