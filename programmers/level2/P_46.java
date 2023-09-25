package com.study.codingtest.programmers.level2;

/*
쿼드 압축
 */
public class P_46 {

    static int[] answer = new int [2];

    static void quad(int x, int y, int size, int[][] arr) {

        //종료조건
        if(isSameNumber(x, y, size, arr)){
            answer[arr[x][y]]++;
            return;
        }

        //반복적으로 나누기
        quad(x, y, size/2, arr);
        quad(x+size/2, y, size/2, arr);
        quad(x, y+size/2, size/2, arr);
        quad(x+size/2, y+size/2, size/2, arr);

    }

    static boolean isSameNumber(int x, int y, int size, int[][] arr) {

        int temp = arr[x][y];
        for(int i=x; i<x+size; i++)
            for(int j=y; j<y+size; j++)
                if(arr[i][j]!=temp)
                    return false;

        return true;
    }

    public int[] solution(int[][] arr) {

        quad(0, 0, arr.length, arr);

        return answer;
    }
}
