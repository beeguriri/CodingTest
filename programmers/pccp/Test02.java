package com.study.codingtest.programmers.pccp;

public class Test02 {
    public int[] solution(String command) {

        int x=0; int y=0; int dir=0;

        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};

        for(char c : command.toCharArray()) {

            if(c=='G') {
                x += dx[dir%4];
                y += dy[dir%4];
            } else if (c=='B') {
                x += dx[(dir+2)%4];
                y += dy[(dir+2)%4];
            } else if (c=='R'){
                dir = (dir+1)%4;
            } else {
                dir = (dir+3)%4;
            }
        }

        return new int [] {x, y};
    }

    public static void main(String[] args) {

    }
}
