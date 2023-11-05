package com.study.codingtest.pccp2;

public class no1 {
    public int[] solution(String command) {
        int[] answer = new int [2];

        //(0,0)에서 시작해서 +y축을 향하여 놓여있음
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};
        int dir = 0;

        for(char c : command.toCharArray()) {

            if(c=='G'){
                answer[0] += dx[dir];
                answer[1] += dy[dir];
            } else if (c=='B') {
                answer[0] -= dx[dir];
                answer[1] -= dy[dir];
            } else if(c=='R'){
                //dir : 0 -> 1-> 2 -> 3 -> ...
                dir = (dir+1)%4;
            } else {
                //dir : 0 -> 3 -> 2 -> 1 -> ...
                dir = (dir+3)%4;
            }
        }

        return answer;
    }
}
