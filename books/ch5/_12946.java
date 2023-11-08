package com.study.codingtest.books.ch5;

import java.util.*;

public class _12946 {

    static List<int []> list = new ArrayList<>();

    static void hanoi (int n, int from, int mid, int to) {
        if(n==0)
            return;

        hanoi(n-1, from, to, mid); //원반을 mid로 옮기고
        list.add(new int [] {from, to}); //마지막 하나는 마지막 기둥으로 옮김
        hanoi(n-1, mid, from, to); // 남은 원반을 mid에서 마지막 기둥으로 옮김

    }

    public int[][] solution(int n) {

        hanoi(n, 1, 2, 3);

        int[][] answer = new int [list.size()][2];

        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}
