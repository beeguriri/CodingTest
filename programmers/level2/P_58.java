package com.study.codingtest.programmers.level2;

import java.util.*;
/*
행렬 테두리 회전하기
 */
public class P_58 {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int [queries.length];
        int [][] board = new int [rows+1][columns+1];

        int num = 1;
        for(int i=1; i<=rows; i++)
            for(int j=1; j<=columns; j++)
                board[i][j] = num++;

        int idx = 0;
        for(int [] query : queries) {

            int min = 10001;

            //변경해야할 숫자들을 stack에 넣고
            //하나씩 빼면서 추가 해주기
            Stack<Integer> stack = new Stack<>();

            for(int i=query[1]; i<=query[3]; i++) {
                stack.push(board[query[0]][i]);
                min = Math.min(min, board[query[0]][i]);
            }

            for(int i=query[0]+1; i<=query[2]; i++){
                stack.push(board[i][query[3]]);
                min = Math.min(min, board[i][query[3]]);
            }

            for(int i=query[3]-1; i>=query[1]; i--){
                stack.push(board[query[2]][i]);
                min = Math.min(min, board[query[2]][i]);
            }

            for(int i=query[2]-1; i>=query[0]+1; i--){
                stack.push(board[i][query[1]]);
                min = Math.min(min, board[i][query[1]]);
            }

            // System.out.println(stack);
            answer[idx++] = min;

            //board 업데이트
            //뒤에서부터 원소 뺄 수 있음
            for(int i=query[0]; i<=query[2]; i++)
                board[i][query[1]] = stack.pop();

            for(int i=query[1]+1; i<=query[3]; i++)
                board[query[2]][i] = stack.pop();

            for(int i=query[2]-1; i>=query[0]; i--)
                board[i][query[3]] = stack.pop();

            for(int i=query[3]-1; i>=query[1]+1; i--)
                board[query[0]][i] = stack.pop();

        }

        return answer;
    }
}
