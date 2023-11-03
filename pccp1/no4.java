package com.study.codingtest.pccp1;
import java.util.*;

public class no4 {

    public long[] solution(int[][] program) {

        //우선순위 큐를 사용하는데,
        //점수가 낮은 것이 우선순위 높음
        //점수가 같을 경우 호출 된 시간이 작은 것이 우선순위 높음

        //도착시간을 비교해서 현재시간보다 빨리 들어온것만 우선순위큐에 넣음
        //우선순위 높은거 실행 후 현재시간+=실행시간
        //대기시간은 현재시간 - 호출된 시간

        //answer[0] = 모든 프로그램의 종료시간
        //answer[i] = 프로그램점수가 i인 프로그램들의 대기시간의 합

        long[] answer = new long [11];
        long time = 0;

        //호출시간 정렬 (호출시간이 같으면서 우선순위도 같은 것은 없다!)
        Arrays.sort(program, (o1, o2) -> o1[1]-o2[1]);

        //우선순위 -> 호출시간으로 정렬
        PriorityQueue<int []> pq = new PriorityQueue<>(
                (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]
        );

        int run = 0;
        int idx = 0;
        while(run<program.length){
            while(idx<program.length && program[idx][1]<=time) {
                pq.offer(program[idx]);
                idx++;
            }

            if(pq.isEmpty())
                time = program[idx][1];
            else {
                //우선순위 제일 높은거 하나 실행
                int [] now = pq.poll();
                answer[now[0]] += (time-now[1]);
                time += now[2];
                run++;
            }
        }

        answer[0] = time;

        return answer;
    }
}
