package com.study.codingtest.books.etc;

public class _49994 {

    public int solution(String dirs) {
        int answer = 0;

        boolean [][][] check = new boolean [11][11][4]; //0 : up, 1 : down, 2 : right, 3 : left
        int ix = 5; int iy = 5;

        for(char c : dirs.toCharArray()){

            int nx = ix; int ny = iy;
            int from = 0;
            int to = 0;

            if(c=='U'){
                nx -= 1;
                from = 0;
                to = 1;
            } else if (c=='D'){
                nx += 1;
                from = 1;
                to = 0;
            } else if (c=='R') {
                ny += 1;
                from = 2;
                to = 3;
            } else {
                ny -= 1;
                from = 3;
                to = 2;
            }

            if(nx<0 || nx>10 || ny<0 || ny >10)
                continue;

            if(!check[ix][iy][from] && !check[nx][ny][to]){
                answer++;
                check[ix][iy][from] = true;
                check[nx][ny][to] = true;
            }

            ix = nx;
            iy = ny;

        }

        return answer;
    }
}
