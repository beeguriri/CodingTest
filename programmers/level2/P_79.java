package com.study.codingtest.programmers.level2;

public class P_79 {
    static int [][] board;
    static int count = 0;

    static boolean isPossible(int row, int col, int n) {

        //같은행 확인
        for(int i=0; i<row; i++)
            if(board[i][col]==1)
                return false;

        //같은 열 확인
        for(int j=0; j<col; j++)
            if(board[row][j]==1)
                return false;

        //왼쪽 대각선 확인
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
            if(board[i][j]==1)
                return false;

        //오른쪽 대각선 확인
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++)
            if(board[i][j]==1)
                return false;

        return true;
    }

    static void nQueen(int row, int n) {

        //재귀함수 종료조건
        if(row==n) {
            count++;
            return;
        }

        for(int col=0; col<n; col++) {
            if(isPossible(row, col, n)) {
                board[row][col] = 1;
                nQueen(row+1, n);
                board[row][col] = 0;
            }
        }

    }

    public int solution(int n) {

        board = new int [n][n];
        nQueen(0, n);

        return count;
    }
}
