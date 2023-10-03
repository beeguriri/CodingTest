package com.study.codingtest.programmers.level2;

import java.util.*;
/*
요격 시스템
 */
public class P_78 {

    public int solution(int[][] targets) {

        //끝나는 시간 기준으로 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int target = targets[0][1];
        int answer = 1;

        for(int i=1; i<targets.length; i++){
            if(targets[i][0]>=target){
                answer++;
                target = targets[i][1];
            }
        }

        return answer;
    }
}
