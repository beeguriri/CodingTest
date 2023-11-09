package com.study.codingtest.books.ch12;

import java.util.LinkedList;
import java.util.Queue;

public class _1844 {

    static int n, m;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static boolean [][] check;

    static void bfs (int x, int y, int [][] map) {

        Queue<int []> qu = new LinkedList<>();
        check[x][y] = true;
        qu.offer(new int [] {x, y});

        while(!qu.isEmpty()){

            int [] now = qu.poll();

            for(int i=0; i<4; i++){

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(!check[nx][ny] && map[nx][ny]!=0){
                    check[nx][ny] = true;
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                    qu.offer(new int [] {nx, ny});
                }
            }

        }
    }

    public int solution(int[][] maps) {

        int answer = 0;

        n = maps.length;
        m = maps[0].length;
        check = new boolean [n][m];

        bfs(0, 0, maps);

        if(!check[n-1][m-1])
            return -1;

        return maps[n-1][m-1];
    }
}
