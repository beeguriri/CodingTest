package com.study.codingtest.programmers.level2;

import java.util.*;

/*
게임 맵 최단거리
 */
public class P_30 {

    static int bfs(int[][] maps) {

        Queue<int []> queue = new LinkedList<>();
        boolean [][] check = new boolean [maps.length][maps[0].length];
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        queue.offer(new int [] {0, 0}); //x, y
        check[0][0] = true;

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            if(now[0]==maps.length-1 && now[1]==maps[0].length-1)
                return maps[now[0]][now[1]];

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length)
                    continue;

                if(!check[nx][ny] && maps[nx][ny]!=0) {
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny});
                    maps[nx][ny] = maps[now[0]][now[1]] + 1;
                }
            }
        }

        return -1;
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }
}

