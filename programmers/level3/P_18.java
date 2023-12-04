package com.study.codingtest.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class P_18 {

    static int n;
    static int [][] map;
    static boolean [][][] check;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    static void bfs(int[][] board){

        Queue<int []> queue = new LinkedList<>();

        check[0][0][0] = true;

        // x, y, 방향, cost
        queue.offer(new int [] {0, 0, -1, 0});

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            if(now[0]==n-1 && now[1]==n-1)
                answer = Math.min(answer, now[3]);

            for(int i=0; i<4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int cost = now[3];

                if(nx<0 || nx>=n || ny<0 || ny>=n || board[nx][ny]==1)
                    continue;

                //방향에 따라 cost 계산
                if(now[2] == -1 || now[2] == i)
                    cost += 100;
                else
                    cost += 600;

                //처음 방문 하거나
                //방문 했다면 이전 값보다 작을 경우에 갱신
                if(!check[nx][ny][i] || cost<=map[nx][ny]) {
                    check[nx][ny][i] = true;
                    map[nx][ny] = cost;
                    queue.offer(new int [] {nx, ny, i, cost});
                }
            }
        }
    }

    public int solution(int[][] board) {

        n = board.length;
        map = new int [n][n];
        check = new boolean [n][n][4];

        bfs(board);

        return answer;
    }
}
