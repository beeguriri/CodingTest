package com.study.codingtest.books.ch12;

import java.util.Arrays;

public class _42862 {

    public int solution(int n, int[] lost, int[] reserve) {

        //체육 수업을 들을 수 있는 학생의 최댓값 구하기
        int answer = n-lost.length;

        //앞뒤로만 빌려줄 수 있으니까 정렬부터 하자
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //문제 제한사항에 따라 lost와 reserve에 동일한 원소가 있을 때
        //lost와 reserve에서 각각 제거해주기
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -10;
                    answer++;
                    break;
                }
            }
        }

        //체육복 빌릴 수 있으면 정답에서 하나씩 추가
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]-1 || lost[i] == reserve[j]+1){
                    reserve[j] = -100;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
