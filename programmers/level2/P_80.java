package com.study.codingtest.programmers.level2;

import java.util.*;

public class P_80 {

    public static int m,n;
    public static int [] oils;
    public static boolean [][] visited;
    public static int [] dx = {1, 0, -1, 0};
    public static int [] dy = {0, 1, 0, -1};

    public static int bfs(int [][] land, int x, int y, Set<Integer> col) {
        int count = 1;
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int [] {x, y});
        visited[x][y] = true;
        col.add(y);

        while (!queue.isEmpty()) {
            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;

                if(visited[nx][ny]) continue;

                if(land[nx][ny]==0) continue;

                visited[nx][ny] = true;
                queue.offer(new int []{nx, ny});
                count++;
                col.add(ny);
            }
        }

        return count;
    }

    public static int solution(int[][] land) {

        m = land.length;
        n = land[0].length;
        oils = new int [n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(!visited[i][j] && land[i][j]==1) {
                    Set<Integer> cols = new HashSet<>();
                    int count = bfs(land, i, j, cols);
                    for(int col : cols)
                        oils[col] += count;
                }
            }
        }
//        System.out.println(Arrays.toString(oils));

        return Arrays.stream(oils).max().getAsInt();
    }

    public static void main(String[] args) {
        int [][] land = new int [][] {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
                };

        System.out.println(solution(land));
    }
}
