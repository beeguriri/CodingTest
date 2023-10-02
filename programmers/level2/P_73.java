package com.study.codingtest.programmers.level2;

import java.util.*;

/*
리코쳇 로봇
 */
public class P_73 {

    static int m, n;
    static char [][] graph;
    static int count = Integer.MAX_VALUE;

    static void bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        boolean [][] check = new boolean [m][n];
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        check[x][y] = true;
        queue.offer(new int [] {x, y, 0});

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            if(graph[now[0]][now[1]]=='G'){
                count = Math.min(count, now[2]);
                return;
            }

            for(int i=0; i<4; i++){

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(graph[nx][ny]=='D')
                    continue;

                //보드판 경계 또는 'D'만날때까지 이동
                while(nx>=0 && nx<m && ny>=0 && ny<n && graph[nx][ny]!='D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                //보드판 경계 또는 'D'에서 루프 빠져나오므로
                nx -= dx[i];
                ny -= dy[i];

                if(!check[nx][ny]){
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny, now[2]+1});
                }
            }

        }

    }

    public int solution(String[] board) {

        m = board.length;
        n = board[0].length();
        graph = new char [m][n];

        int x=0; int y=0;

        //시작위치 찾기
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                graph[i][j] = board[i].charAt(j);

                if(graph[i][j]=='R'){
                    x=i;
                    y=j;
                }
            }
        }

        bfs(x, y);

        return count == Integer.MAX_VALUE ? -1 : count;
    }
}
