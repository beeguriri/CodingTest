package com.study.codingtest.programmers.level2;

import java.util.*;
/*
더 맵게
 */
public class P_29 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위큐에서 두개 꺼내서 연산 후 다시 push
        //연산횟수만금 answer++;
        //peek한게 스코빌보다 높으면 break;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville)
            pq.offer(i);

        while(!pq.isEmpty()) {

            if(pq.peek()>=K)
                break;

            if(pq.size()<=1)
                return -1;

            int x = pq.poll();
            int y = pq.poll();
            pq.offer(x+2*y);
            answer++;
        }

        return answer;
    }
}
