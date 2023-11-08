package com.study.codingtest.books.ch4;

public class _12930 {

    static String makeWord(String s) {

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(i%2==0)
                answer.append(s.substring(i, i + 1).toUpperCase());
            else
                answer.append(s.substring(i, i + 1).toLowerCase());
        }

        return answer.toString();
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' '){
                answer.append(makeWord(s.substring(idx, i)));
                answer.append(' ');
                idx = i+1; //다음 단어 시작점
            }
        }

        //공백 이후 남은 단어 처리
        answer.append(makeWord(s.substring(idx)));

        return answer.toString();
    }
}
