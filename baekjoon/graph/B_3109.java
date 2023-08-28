package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_3109 {

    //최단 경로 찾을게 아니고
    //연결 가능 여부만 확인 할 거라서
    //dfs로 풀 예정

    static int r, c;
    static char [][] board;

//    public static boolean dfs(int x, int y) {
//
//        if(y == c-1)
//            return true;
//
//        if(x<0 || x>=r-1 || y<0 || y>=c-1)
//            return false;
//
//        if(board[x][y]=='.'){
//            board[x][y] = 'O';
//            //각 칸은 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결
//            //처음 탐색 순서가 중요!!! 위에서 부터 설치해서 내려오기
//            dfs(x-1, y+1);
//            dfs(x, y+1);
//            dfs(x+1, y+1);
//
////            board[x][y] = 'O';
//
//            return true;
//        }
//
//        return false;
//    }

    static boolean dfs(int x, int y) {

        board[x][y] = 'O';

        if(y==c-1)
            return true;

        if(x>0 && board[x-1][y+1]=='.')
            if(dfs(x-1, y+1))
                return true;

        if(board[x][y+1]=='.')
            if(dfs(x, y+1))
                return true;

        if(x+1<r && board[x+1][y+1]=='.')
            if(dfs(x+1, y+1))
                return true;

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = br.readLine().split(" ");
        r = Integer.parseInt(temp[0]);
        c = Integer.parseInt(temp[1]);

        board = new char[r][c];
        for(int i=0; i<r; i++)
            board[i] = br.readLine().toCharArray();

        int result = 0;
        for(int i=0; i<r; i++){
            if(board[i][1]=='.' && dfs(i, 1)) {
                result++;
//                for(char [] b : board)
//                    System.out.println(Arrays.toString(b));
//                System.out.println("=".repeat(20));
            }
        }

        System.out.println(result);
    }
}
