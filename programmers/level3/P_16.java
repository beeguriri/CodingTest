package com.study.codingtest.programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_16 {

    /*
    디스크 컨트롤러
    Shortest Job First
     */
    public static int solution(int[][] jobs) {

        int answer = 0;

        //작업 시작 시간 순서 대로 우선 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        //꺼낼 때는 작업 시간 짧은 순으로
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);

        int count = 0;
        int end = 0;
        int idx = 0;

        while(count<jobs.length) {

            //하나의 작업이 완료 시간 동안 수행 가능한 job 을 모두 pq에 넣음
            //하나의 작업 끝나고 나면 pq에 들어온 것 중
            //실행 시간 짧은거 부터 수행
            while(idx<jobs.length && jobs[idx][0]<=end)
                pq.offer(jobs[idx++]);

            //큐가 비어 있으면 end를 다음 작업의 시작시간으로
            if(pq.isEmpty())
                end = jobs[idx][0];
            else {
                int [] temp = pq.poll();
                answer += (end + temp[1] - temp[0]);
                end += temp[1];
                count++;
            }
        }

        return answer/jobs.length;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][] {{0, 3}, {1, 9}, {2, 6}})); //9
    }
}
