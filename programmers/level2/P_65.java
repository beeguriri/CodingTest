package com.study.codingtest.programmers.level2;

/*
가장 큰 정사각형 찾기
 */
public class P_65 {

    public int solution(int [][]board){

        int [][] dp = new int [board.length+1][board[0].length+1];

        //dp 배열 초기화
        for(int i=1; i<dp.length; i++)
            for(int j=1; j<dp[0].length; j++)
                dp[i][j] = board[i-1][j-1];

        //왼쪽, 위쪽, 대각선 값 확인
        int max = 0;
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(dp[i][j]!=0) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }


        return max*max;
    }
}
