package com.study.codingtest.programmers.books.ch10;

public class _42898 {

    static final int MOD = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] board = new int [n+1][m+1];

        for(int [] puddle : puddles)
            board[puddle[1]][puddle[0]] = -1;

        //시작점
        board[1][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(board[i][j]==-1)
                    continue;

                if(board[i-1][j]!=-1)
                    board[i][j] += board[i-1][j];

                if(board[i][j-1]!=-1)
                    board[i][j] += board[i][j-1];

                board[i][j] %= MOD;
            }
        }

        // System.out.println(Arrays.deepToString(board));

        return board[n][m];
    }
}
