package com.study.codingtest.books.ch4;

public class _68935 {

    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);
        StringBuilder reverse = new StringBuilder();
        for(int i = str.length()-1; i>=0; i--)
            reverse.append(str.charAt(i));

        answer = Integer.parseInt(reverse.toString(), 3);

        return answer;
    }
}
