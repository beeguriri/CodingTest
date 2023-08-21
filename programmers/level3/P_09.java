package com.study.codingtest.programmers.level3;

import java.util.Arrays;

public class P_09 {
    /*
        단속 카메라
        routes[i][0]에는 i번째 차량이 진입한 지점, routes[i][1]에는 나간 지점
     */

    public static int solution(int[][] routes) {

        //회의실 문제
        //종료 시간 기준으로 정렬
        //target은 종료시간
        //시작 시간이 종료시간보다 빠르면 카메라 설치해야됨
        //겹쳐도 된다고 했으므로 부등호 잘 처리해주기
        Arrays.sort(routes, (o1, o2) -> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);
        int last = routes[0][1];
        int count = 1;

        for(int [] route : routes) {

            if(route[0]>last) {
                count++;
                last = route[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][] {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})); //2
    }
}
