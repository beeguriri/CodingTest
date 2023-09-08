package com.study.codingtest.programmers.level1;

import java.util.Arrays;

public class P_06 {

    public int solution(int n, int[] lost, int[] reserve) {

        //일단 잃어버린 애들 안치고 시작
        int answer = n-lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //중복 제거
        for(int l=0; l<lost.length; l++) {
            for(int i=0; i<reserve.length; i++) {
                if(lost[l] == reserve[i]) {
                    reserve[i] = -1;
                    lost[l] = -1;
                    answer++;
                }
            }
        }


        for(int l : lost) {
            for(int i=0; i<reserve.length; i++) {
                if(reserve[i]-1==l || reserve[i]+1==l){
                    answer++;
                    reserve[i] = -100;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
