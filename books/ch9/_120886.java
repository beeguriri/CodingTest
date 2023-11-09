package com.study.codingtest.books.ch9;

import java.util.Arrays;

public class _120886 {

    public int solution(String before, String after) {

        char [] parseBefore = before.toCharArray();
        char [] parseAfter = after.toCharArray();

        Arrays.sort(parseBefore);
        Arrays.sort(parseAfter);

        for(int i=0; i<before.length(); i++){
            if(parseBefore[i]!=parseAfter[i])
                return 0;
        }

        return 1;
    }
}
