package com.study.codingtest.programmers.books.ch3;

public class _68645 {

    public int[] solution(int n) {
        int[] answer = new int [n*(n+1)/2];
        int [][] board = new int [n][n];
        int num = 1;
        int row = -1; //row는 0,0에서 부터 시작
        int col = 0; //col은 row,1에서 부터 시작

        //n -> n-1 -> ... -> 1 개 순으로 줄어듦
        for(int i=0; i<n; i++) {

            //i=0일때 row++, i=1일때 col++, i=2일때 row--, col--, ...
            for(int j=i; j<n; j++) {
                if(i%3==0) {
                    board[++row][col] = num++;
                } else if(i%3==1) {
                    board[row][++col] = num++;
                } else {
                    board[--row][--col] = num++;
                }
            }
        }

        int idx= 0;
        for(int [] b : board)
            for(int i : b)
                if(i!=0)
                    answer[idx++] = i;

        return answer;
    }
}
