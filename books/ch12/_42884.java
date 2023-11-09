package com.study.codingtest.books.ch12;

import java.util.Arrays;

public class _42884 {

    public int solution(int[][] routes) {

        //끝나는 시간 기준으로 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int prev = routes[0][1];
        int answer = 1;

        //prev가 다음 시작점보다 크거나 같으면 continue;
        //(차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.)
        //prev가 다음 시작점보다 작으면 answer++;
        for(int [] route : routes){
            if(prev < route[0]){
                prev = route[1];
                answer++;
            }
        }

        return answer;
    }
}
