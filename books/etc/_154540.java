package com.study.codingtest.books.etc;

import java.util.*;

public class _154540 {

    static boolean [][] check;
    static int [][] board;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    static int bfs(int x, int y) {

        int sum = board[x][y];
        Queue<int []> qu = new LinkedList<>();
        qu.offer(new int [] {x, y});
        check[x][y] = true;

        while(!qu.isEmpty()) {

            int [] now = qu.poll();

            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length)
                    continue;

                if(!check[nx][ny] && board[nx][ny]!=0){
                    check[nx][ny] = true;
                    qu.offer(new int [] {nx, ny});
                    sum += board[nx][ny];
                }
            }
        }

        return sum;
    }

    public int[] solution(String[] maps) {

        List<Integer> list = new ArrayList<>();
        board = new int [maps.length][maps[0].length()];
        check = new boolean [maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            String [] temp = maps[i].split("");
            for(int j=0; j<maps[0].length(); j++) {
                if(temp[j].equals("X"))
                    board[i][j] = 0;
                else
                    board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                if(!check[i][j] && board[i][j]!=0)
                    list.add(bfs(i, j));
            }
        }

        Collections.sort(list);

        return list.isEmpty() ? new int [] {-1} : list.stream().mapToInt(i->i).toArray();
    }
}
