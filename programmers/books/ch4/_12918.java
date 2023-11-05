package com.study.codingtest.programmers.books.ch4;

public class _12918 {

    static boolean isDigit(String s) {
        for(char c : s.toCharArray())
            if(!(c>='0' && c<='9'))
                return false;
        return true;
    }

    public boolean solution(String s) {
        boolean answer = true;

        return (s.length()==4 || s.length()==6) && isDigit(s);
    }
}
