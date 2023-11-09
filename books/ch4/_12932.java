package com.study.codingtest.books.ch4;

public class _12932 {

    public int[] solution(long n) {

        String s = String.valueOf(n);

        int[] answer = new int [s.length()];
        int idx = 0;
        for(int i=s.length()-1; i>=0; i--)
            answer[idx++] = Integer.parseInt(s.substring(i, i+1));

        return answer;
    }
}
