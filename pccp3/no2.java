package com.study.codingtest.pccp3;

import java.util.LinkedList;
import java.util.Queue;

public class no2 {

    static int n, m;
    static int [] oils; //최대값 기록용
    static boolean [][] check;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    static void bfs(int x, int y, int[][] land) {

        Queue<int []> queue = new LinkedList<>();
        Queue<int []> record = new LinkedList<>();
        boolean [] colCheck = new boolean [m];

        check[x][y] = true;
        queue.offer(new int [] {x, y});
        record.offer(new int [] {x, y});

        int count = 1;

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            for(int i=0; i<4; i++){

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx >=n || ny >= m)
                    continue;

                if(!check[nx][ny] && land[nx][ny]==1){
                    check[nx][ny] = true;
                    queue.offer(new int []{nx, ny});
                    record.offer(new int []{nx, ny});
                    count++;
                }
            }
        }

        while(!record.isEmpty()){
            int [] now = record.poll();
            if(!colCheck[now[1]]){
                colCheck[now[1]] = true;
                oils[now[1]] += count;
            }
        }
    }

    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oils = new int [m];
        check = new boolean [n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!check[i][j] && land[i][j]==1)
                    bfs(i,j,land);
            }
        }

        for(int oil : oils)
            answer = Math.max(answer, oil);

        return answer;
    }
}
