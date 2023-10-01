package com.study.codingtest.programmers.level2;

import java.util.*;

/*
하노이의 탑
 */

public class P_70 {

    static List<int []> list = new ArrayList<>();

    static void hanoi(int n, int from, int mid, int to) {

        //종료조건
        if(n==0)
            return;

        //n-1개를 1->2번 기둥으로 옮기고
        hanoi(n-1, from, to, mid);
        //1개를 1->3번 기둥으로 옮기고
        list.add(new int [] {from, to});
        //n-1개를 2->3번 기둥으로 옮김
        hanoi(n-1, mid, from, to);

    }

    public int[][] solution(int n) {

        hanoi(n, 1, 2, 3);

        int [][] answer = new int [list.size()][2];
        int idx = 0;
        for(int [] i : list)
            answer[idx++] = i;

        return answer;
    }
}
