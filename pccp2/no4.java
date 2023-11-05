package com.study.codingtest.pccp2;

import java.util.*;

public class no4 {

    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static boolean [][] board;
    static boolean [][][] check; //x, y, 점프 할수 있으면 1, 없으면 0

    static class Node {
        public int x;
        public int y;
        public int canJump;
        public int distance;

        Node(int x, int y, int canJump, int distance){
            this.x = x;
            this.y = y;
            this.canJump = canJump;
            this.distance = distance;
        }
    }

    static int bfs(int sx, int sy, int ex, int ey, int m, int n) {

        Queue<Node> queue = new LinkedList<>(); //x, y, (사용가능 1), 거리;
        queue.offer(new Node(sx, sy, 1, 0));
        check[sx][sy][1] = true;

        while(!queue.isEmpty()) {

            Node now = queue.poll();

            if(now.x == ex && now.y == ey)
                return now.distance;

            for(int i=0; i<4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny][now.canJump] && board[nx][ny]){
                    check[nx][ny][now.canJump] = true;
                    queue.offer(new Node(nx, ny, now.canJump, now.distance+1));
                }

                //jump 할 수 없으면 continue;
                if(now.canJump != 1)
                    continue;

                //jump 할 수 있으면,
                nx = now.x + dx[i]*2;
                ny = now.y + dy[i]*2;

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny][0] && board[nx][ny]) {
                    check[nx][ny][0] = true;
                    queue.offer(new Node(nx, ny, 0, now.distance+1));
                }
            }
        }

        return -1;
    }

    public int solution(int n, int m, int[][] hole) {
        int answer = 0;

        board = new boolean [m][n];
        for(boolean [] b : board)
            Arrays.fill(b, true);

        for(int [] h : hole) {
            int row = m-h[1];
            int col = h[0]-1;
            board[row][col] = false;
        }

        check = new boolean [m][n][2];

        // for(boolean [] b : board)
        //     System.out.println(Arrays.toString(b));

        return bfs(m-1, 0, 0, n-1, m, n);
    }
}
