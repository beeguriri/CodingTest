package com.study.codingtest.programmers.level2;

import java.util.*;
/*
미로 탈출
 */

public class P_71 {

    static int m, n;
    static char[][] board;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    static int bfs(int x, int y, char target) {

        Queue<int []> queue = new LinkedList<>();
        boolean [][] check = new boolean [m][n];
        check[x][y] = true;
        queue.offer(new int [] {x, y, 0});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            if(board[now[0]][now[1]]==target)
                return now[2];

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny] && board[nx][ny]!='X'){
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny, now[2]+1});
                }
            }

        }
        return -1;
    }

    public int solution(String[] maps) {

        m = maps.length;
        n = maps[0].length();
        board = new char [m][n];

        int [] start = new int [2];
        int [] lever = new int [2];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = maps[i].charAt(j);

                if(board[i][j]=='S')
                    start = new int [] {i, j};

                if(board[i][j]=='L')
                    lever = new int [] {i, j};
            }
        }

        //S -> 레버까지 최단거리 이동
        int s = bfs(start[0], start[1], 'L');
        //레버에서 출구까지 최단거리 이동
        int l = bfs(lever[0], lever[1], 'E');

        if(s==-1 || l==-1)
            return -1;

        return s+l;
    }
}
