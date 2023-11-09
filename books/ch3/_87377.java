package com.study.codingtest.books.ch3;

import java.util.*;

public class _87377 {

    public String[] solution(int[][] line) {

        int minX=Integer.MAX_VALUE; int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE; int maxY=Integer.MIN_VALUE;

        //1. 정수인 교점을 찾고
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<line.length-1; i++){

            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];

            for(int j=i+1; j<line.length; j++) {

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                //int형 두 숫자 곱할 때 오버플로우 일어날 수 있음!!!
                long adbc = a*d - b*c;
                long bfed = b*f - e*d;
                long ecaf = e*c - a*f;

                if(adbc==0) continue;

                if(bfed%adbc==0 && ecaf%adbc==0){
                    int x = (int)(bfed/adbc);
                    int y = (int)(ecaf/adbc);
                    list.add(new int [] {x, y});
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                    minY = Math.min(minY, y);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        //2. 별을 우선 배열로 만들고 출력하기
        String [][] board = new String [maxY-minY+1][maxX-minX+1];
        for(String [] s : board)
            Arrays.fill(s, ".");

        //x : (x-minX)
        //y : (maxY-y)
        //x, y 스왑
        for(int [] l : list)
            board[maxY - l[1]][l[0] - minX] = "*";

        // for(char [] c : board)
        //     System.out.println(Arrays.toString(c));

        String [] answer = new String[board.length];
        for(int i=0; i<board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(String s : board[i])
                sb.append(s);
            answer[i] = sb.toString();
        }

        return answer;
    }

}
