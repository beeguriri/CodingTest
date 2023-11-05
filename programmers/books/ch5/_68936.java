package com.study.codingtest.programmers.books.ch5;

public class _68936 {

    static int [] answer = new int [2];

    static boolean isSameNumber(int x, int y, int size, int [][] arr) {

        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[i][j]!=arr[x][y])
                    return false;
            }
        }
        return true;
    }

    static void dfs(int x, int y, int size, int [][] arr) {

        //종료조건
        if(isSameNumber(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        dfs(x, y, size/2, arr);
        dfs(x+size/2, y, size/2, arr);
        dfs(x, y+size/2, size/2, arr);
        dfs(x+size/2, y+size/2, size/2, arr);

    }

    public int[] solution(int[][] arr) {
        dfs(0, 0, arr.length, arr);
        return answer;
    }
}
