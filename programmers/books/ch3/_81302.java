package com.study.codingtest.programmers.books.ch3;

public class _81302 {

    static boolean isPossible(int x, int y, char[][] board) {

        //1칸 체크
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 ||  nx>=5 || ny<0 || ny>= 5)
                continue;

            if(board[nx][ny]=='P')
                return false;
        }

        //2칸 체크
        int [] dx2 = {-2, 0, 2, 0};
        int [] dy2 = {0, -2, 0, 2};
        for(int i=0; i<4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];

            if(nx<0 ||  nx>=5 || ny<0 || ny>= 5)
                continue;

            if(board[nx][ny]=='P')
                if(board[(x+nx)/2][(y+ny)/2]!='X')
                    return false;
        }

        //대각선 체크
        int [] dx3 = {-1, -1, 1, 1};
        int [] dy3 = {-1, 1, -1, 1};
        for(int i=0; i<4; i++){
            int nx = x + dx3[i];
            int ny = y + dy3[i];

            if(nx<0 ||  nx>=5 || ny<0 || ny>= 5)
                continue;

            if(board[nx][ny]=='P')
                if(board[x][ny]!='X' || board[nx][y]!='X')
                    return false;

        }

        return true;
    }

    static boolean checkBoard(char[][] board) {

        for(int i=0; i<5; i++)
            for(int j=0; j<5; j++)
                if(board[i][j]=='P')
                    if(!isPossible(i, j, board))
                        return false;

        return true;

    }

    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];

        for(int i=0; i<places.length; i++) {

            char[][] board = new char[5][5];
            for(int j=0; j<5; j++)
                board[j] = places[i][j].toCharArray();

            if(checkBoard(board))
                answer[i] = 1;
        }

        return answer;
    }
}
