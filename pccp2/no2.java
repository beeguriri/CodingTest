package com.study.codingtest.pccp2;

import java.util.*;

public class no2 {

    public int solution(int[] ability, int number) {
        int answer = 0;
        //최소힙을 구성해서 교육 횟수만큼 순회하면 되지않을까?
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : ability)
            pq.offer(i);

        while(number>0) {
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(x+y);
            pq.offer(x+y);
            number--;
        }

        while(!pq.isEmpty())
            answer += pq.poll();

        return answer;
    }
}
