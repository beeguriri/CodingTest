package com.study.codingtest.baekjoon.bruteforce;

/*
체스판 다시 칠하기
8*8로 자르는 경우에서
시작이 W인 경우와 B인 경우 각각 계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1018 {

    static int m, n;
    static char [][] board;
    static int countBoard(int sx, int sy){

        int countW = 0;
        int countB = 0;
        char [][] boardW = new char[8][8];
        char [][] boardB = new char[8][8];
        char [][] copyBoard = new char[8][8];
        //원본 보드
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                copyBoard[i][j] = board[sx+i][sy+j];
            }
        }
        //검사용 보드
        String startW = "WBWBWBWB";
        String startB = "BWBWBWBW";
        for(int i=0; i<8; i++){
            if(i%2==0){
                boardW[i] = startW.toCharArray();
                boardB[i] = startB.toCharArray();
            } else {
                boardW[i] = startB.toCharArray();
                boardB[i] = startW.toCharArray();
            }
        }

        //확인
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(copyBoard[i][j]!=boardW[i][j])
                    countW++;

                if(copyBoard[i][j]!=boardB[i][j])
                    countB++;

            }
        }

        return Math.min(countW, countB);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        m = Integer.parseInt(str.split(" ")[0]);
        n = Integer.parseInt(str.split(" ")[1]);

        board = new char [m][n];
        for(int i=0; i<m; i++){
            str = br.readLine();
            board[i] = str.toCharArray();
        }

        //board 잘라서 확인
        int count = Integer.MAX_VALUE;
        for(int i=0; i<m-8+1; i++){
            for(int j=0; j<n-8+1; j++){
                count = Math.min(count, countBoard(i, j));
            }
        }

        System.out.println(count);
    }
}
