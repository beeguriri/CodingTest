package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
단지 번호 붙이기
bfs로 풀어야지
총 단지 수
각 단지번호에 대한 집의 수 출력
 */
public class B_2667 {

    static int m;
    static int count = 0;
    static char [][] board;
    static boolean [][] check;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};

    static void bfs(int x, int y){
        Queue<int []> queue = new LinkedList<>();
        check[x][y] = true;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()){
            int [] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=m)
                    continue;

                if(!check[nx][ny] && board[nx][ny]=='1'){
                    count++;
                    check[nx][ny] = true;
                    queue.offer(new int [] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        board = new char[m][m];
        check = new boolean[m][m];

        for(int i=0; i<m; i++){
            String temp = br.readLine();
            board[i] = temp.toCharArray();
        }

        int number = 0; //단지수 카운트
        List<Integer> list = new ArrayList<>(); //단지 별 아파트 수 저장

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++) {
                if(!check[i][j] && board[i][j]=='1'){
                    count = 1;
                    bfs(i, j);
                    number++;
                    list.add(count);
                }
            }
        }

        System.out.println(number);
        Collections.sort(list);
        for(int i : list)
            System.out.println(i);
    }
}
