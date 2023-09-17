package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_17086 {

    static int m, n;
    static int [][] board;
    static int [] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int [] dy = {0, -1, 0, 1, -1, 1, -1, 1};

    static int bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        boolean [][] check = new  boolean[m][n];
        check[x][y] = true;
        queue.offer(new int [] {x, y, 0});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            if(board[now[0]][now[1]]==1)
                return now[2];

            for(int i=0; i<8; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny]){
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny, now[2]+1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int [m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int distance = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(board[i][j]==0){
                    distance = Math.max(distance, bfs(i, j));
                }
            }
        }

        System.out.println(distance);
    }
}
