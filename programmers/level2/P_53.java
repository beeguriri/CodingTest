package com.study.codingtest.programmers.level2;

import java.util.*;

/*
무인도 여행
 */

public class P_53 {

    static List<Integer> result = new ArrayList<>();
    static char [][] board;
    static boolean [][] check;
    static int m, n;

    static int bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>(); //x, y
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        check[x][y] = true;
        queue.add(new int [] {x, y});
        int count = Integer.parseInt(String.valueOf(board[x][y]));

        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!check[nx][ny] && board[nx][ny]!='X'){
                    check[nx][ny] = true;
                    count += Integer.parseInt(String.valueOf(board[nx][ny]));
                    queue.offer(new int [] {nx, ny});
                }
            }
        }

        return count;

    }

    public int[] solution(String[] maps) {

        //초기세팅
        m = maps.length;
        n = maps[0].length();
        board = new char [m][n];
        check = new boolean [m][n];

        for(int i=0; i<m; i++)
            board[i] = maps[i].toCharArray();

        //bfs 탐색
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(!check[i][j] && board[i][j]!='X')
                    result.add(bfs(i, j));

        // System.out.println(Arrays.deepToString(board));
        // System.out.println(result);
        if(result.isEmpty())
            return new int [] {-1};

        Collections.sort(result);

        int [] answer = new int [result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}
