package com.study.codingtest.programmers.level2;

/*
거리두기 확인하기
 */
public class P_66 {

    static boolean checkSeat(char [][] board, int x, int y) {

        //상하좌우
        int [] dx1 = {-1, 0, 1, 0};
        int [] dy1 = {0, -1, 0, 1};

        for(int i=0; i<4; i++) {
            int nx = x+dx1[i];
            int ny = y+dy1[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P')
                return false;
        }

        //상하좌우*2
        int [] dx2 = {-2, 0, 2, 0};
        int [] dy2 = {0, -2, 0, 2};

        for(int i=0; i<4; i++) {
            int nx = x+dx2[i];
            int ny = y+dy2[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P')
                if(board[(x+nx)/2][(y+ny)/2]!='X')
                    return false;
        }

        //대각선
        int [] dx3 = {-1, -1, 1, 1};
        int [] dy3 = {-1, 1, -1, 1};

        for(int i=0; i<4; i++) {
            int nx = x+dx3[i];
            int ny = y+dy3[i];

            if(nx<0 || nx>=5 || ny<0 || ny>=5)
                continue;

            if(board[nx][ny]=='P')
                if(!(board[x][ny]=='X' && board[nx][y]=='X'))
                    return false;
        }

        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int [5];

        for(int i=0; i<5; i++) {

            //check 확인용
            boolean flag = true;

            //board 입력
            char [][] board = new char [5][5];
            String [] place = places[i];
            for(int j=0; j<5; j++)
                board[j] = place[j].toCharArray();

            //board 순회
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(board[j][k]=='P') {
                        if(!checkSeat(board, j, k)){
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag)
                    break;
            }

            answer[i] = flag ? 1 : 0;
        }

        return answer;
    }
}
