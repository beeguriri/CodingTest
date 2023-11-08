package com.study.codingtest.books.ch4;

public class _12926 {

    //a => 97, z => 122
    //A => 65, Z => 90
    static char rotateChar(char c, int n) {
        if(c>='a' && c<='z') {
            if((int)c+n <= 122)
                return (char)((int)c+n);
            else
                return (char)((int)c+n-26);
        } else {
            if((int)c+n<=90)
                return (char)((int)c+n);
            else
                return (char)((int)c+n-26);
        }

    }

    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c!=' ')
                c = rotateChar(c, n);
            answer += String.valueOf(c);
        }

        return answer;
    }
}
