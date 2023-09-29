package com.study.codingtest.programmers.level2;

import java.util.*;

/*
줄서는 방법
 */

public class P_60 {
    public int[] solution(int n, long k) {

        int [] answer = new int [n];
        long fact = 1;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            fact *= i;
            list.add(i);
        }

        int idx = 0;
        k = k-1;

        while(n>0){

            //단위 개수 구하기(맨 앞자리 묶음수)
            fact /= n;

            //단위 내 k번째의 위치 구하기
            answer[idx++] = list.get((int)(k/fact));
            list.remove((int)(k/fact));

            //다음순번
            k %= fact;
            n--;

        }

        return answer;
    }
}
