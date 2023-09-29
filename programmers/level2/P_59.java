package com.study.codingtest.programmers.level2;

import java.util.*;
/*
호텔 대실
시작시간 오름차순으로 정렬하고
종료시간을 우선순위 큐에 넣고 비교하기
 */

public class P_59 {

    //시간계산 메서드
    static int calcTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return h*60 + m;
    }

    public int solution(String[][] book_time) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //시작시간 기준 오름차순 정렬
        Arrays.sort(book_time, (o1, o2) ->
                calcTime(o1[0]) == calcTime(o2[0]) ?
                        calcTime(o1[1]) - calcTime(o2[1]) : calcTime(o1[0]) - calcTime(o2[0]));

        // System.out.println(Arrays.deepToString(book_time));

        for(String [] book : book_time){

            if(pq.isEmpty()) {
                pq.offer(calcTime(book[1])+10);
                continue;
            }

            if(calcTime(book[0])>=pq.peek())
                pq.poll();

            pq.offer(calcTime(book[1])+10);
        }

        return pq.size();
    }
}
