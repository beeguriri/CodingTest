package com.study.codingtest.books.ch4;

public class _12916 {

    boolean solution(String s) {

        s = s.toUpperCase();

        int countP = 0;
        int countY = 0;

        for(char c : s.toCharArray()){
            if(c=='P')
                countP++;
            else if(c=='Y')
                countY++;
        }

        return countP == countY;
    }
}
