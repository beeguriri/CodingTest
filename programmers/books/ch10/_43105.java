package com.study.codingtest.programmers.books.ch10;

public class _43105 {

    public int solution(int[][] triangle) {

        //제일 왼쪽 원소는 바로 윗행의 제일 왼쪽만 가질 수 있음
        //제일 오른쪽 원소는 바로 윗행의 제일 마지막원소만 가질 수 있음
        //나머지는 바로 윗행의 j-1열과 j열값 비교해서 최대값 더해주기
        int answer = 0;

        for(int i=1; i<triangle.length; i++) {

            for(int j=0; j<triangle[i].length; j++) {
                if(j==0)
                    triangle[i][0] += triangle[i-1][0];
                else if(j==triangle[i].length-1)
                    triangle[i][triangle[i].length-1] += triangle[i-1][triangle[i].length-2];
                else
                    triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);

            }
        }

        for(int i=0; i<triangle[triangle.length-1].length; i++)
            answer = Math.max(answer, triangle[triangle.length-1][i]);

        return answer;
    }
}
