package com.study.codingtest.programmers.books.ch6;

public class _42842 {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];

        int x = 0; int y = 0;
        for(int i=1; i<=Math.sqrt(yellow); i++){

            //x, y를 구하고
            if(yellow%i==0) {
                x = yellow/i;
                y = i;
            }
            //갈색의 갯수가 맞는지 확인 한 다음에
            //결과 반환
            if(x*2 + y*2 + 4 == brown) {
                answer[0] = x+2;
                answer[1] = y+2;
                break;
            }
        }

        return answer;
    }
}
