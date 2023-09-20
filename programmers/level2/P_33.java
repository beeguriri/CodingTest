package com.study.codingtest.programmers.level2;

/*
방문 길이
U: 위쪽으로 한 칸 가기 : -1, 0 => 0
D: 아래쪽으로 한 칸 가기 : 1, 0 => 1
R: 오른쪽으로 한 칸 가기 : 0, 1 => 2
L: 왼쪽으로 한 칸 가기 : -1, 0 => 3
board : 11 * 11
처음위치 : 5, 5
 */
public class P_33 {
    public int solution(String dirs) {
        int answer = 0;
        boolean [][][] check = new boolean [11][11][4]; //x,y,dir check

        int ix = 5;
        int iy = 5;

        for(char c : dirs.toCharArray()) {

            int nx = ix;
            int ny = iy;
            int dFrom, dTo; //U : 0, D : 1, R : 2, L : 3

            if(c=='U'){
                nx -= 1;
                dFrom = 1;
                dTo = 0;
            } else if(c=='D') {
                nx += 1;
                dFrom = 0;
                dTo = 1;
            } else if(c=='R') {
                ny += 1;
                dFrom = 3;
                dTo = 2;
            } else {
                ny -= 1;
                dFrom = 2;
                dTo = 3;
            }

            if(nx<0 || nx>=11 || ny<0 || ny>=11)
                continue;

            if(!check[ix][iy][dFrom] && !check[nx][ny][dTo]) {
                check[ix][iy][dFrom] = true;
                check[nx][ny][dTo] = true;
                answer++;
            }

            ix = nx;
            iy = ny;
        }

        return answer;
    }
}
