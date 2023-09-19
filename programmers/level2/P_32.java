package com.study.codingtest.programmers.level2;

/*
땅따먹기
 */

public class P_32 {

    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                //열의 개수 4개!
                if(j==0)
                    land[i][j] = Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3])) + land[i][j];
                else if (j==1)
                    land[i][j] = Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3])) + land[i][j];
                else if (j==2)
                    land[i][j] = Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3])) + land[i][j];
                else
                    land[i][j] = Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2])) + land[i][j];
            }
        }

        for(int i : land[land.length-1])
            answer = Math.max(answer, i);

        return answer;
    }
}
