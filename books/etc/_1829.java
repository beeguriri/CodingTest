package com.study.codingtest.books.etc;

import java.util.LinkedList;
import java.util.Queue;

public class _1829 {

    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    static boolean [][] check;

    static int bfs(int x, int y, int m, int n, int[][] picture) {

        int target = picture[x][y];
        int count = 1;

        Queue<int []> qu = new LinkedList<>();
        qu.offer(new int [] {x, y});
        check[x][y] = true;

        while(!qu.isEmpty()){

            int [] now = qu.poll();

            for(int i=0; i<4; i++){

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny] && picture[nx][ny]==target){
                    check[nx][ny] = true;
                    qu.offer(new int [] {nx, ny});
                    count++;
                }
            }
        }

        return count;
    }

    public int[] solution(int m, int n, int[][] picture) {

        int [] answer = new int [2];
        check = new boolean [m][n];

        //[영역의 갯수, 가장 큰 영역의 크기]
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(!check[i][j] && picture[i][j]!=0){
                    int temp = bfs(i, j, m, n, picture);
                    answer[1] = Math.max(answer[1], temp);
                    answer[0]++;
                }
            }
        }

        return answer;
    }
}
