package com.study.codingtest.programmers.books.ch11;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _42627 {

    //요청 수행하는 동안 들어온 작업들을 대기큐에 넣고
    //작업시간이 짧은 것부터 수행하기
    public int solution(int[][] jobs) {

        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        int run = 0;
        int time = 0;
        int idx = 0;
        int answer = 0;

        //작업시작시간 짧은 순으로 정렬 하고
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while(run<jobs.length){

            //현재 시간보다 이전에 들어온 작업이 있으면 대기큐에 넣어주기
            while(idx<jobs.length && jobs[idx][0]<=time)
                pq.offer(jobs[idx++]);

            //작업할 게 없으면 현재시간 갱신
            if(pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }

            //대기큐에 있는 작업들 처리
            int [] now = pq.poll();
            answer += (time-now[0]+now[1]);
            time += now[1];
            run++;

        }

        // System.out.println(time);
        // System.out.println(answer);

        return answer/jobs.length;
    }
}
