package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B_2589 {

    /*
    보물섬
    모든 출발점에 대해 경로 길이 구하기
     */

    static int m, n;
    static char [][] board;
    static boolean [][] check;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    static int bfs(int x, int y) {

        Queue <int []> queue = new LinkedList<>();
        check[x][y] = true;
        queue.offer(new int [] {x, y, 0});

        int result = 0;

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny] && board[nx][ny]=='L') {
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny, now[2]+1});
                    result = Math.max(result, now[2]+1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] temp = br.readLine().split(" ");
        m = Integer.parseInt(temp[0]);
        n = Integer.parseInt(temp[1]);

        board = new char[m][n];

        for(int i=0; i<m; i++)
            board[i] = br.readLine().toCharArray();

        int maxVal = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(board[i][j]=='L') {
                    check = new boolean[m][n];
                    maxVal = Math.max(maxVal, bfs(i,j));
                }
            }
        }

        System.out.println(maxVal);
    }
}
