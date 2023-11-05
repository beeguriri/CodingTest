package com.study.codingtest.pccp2;

import java.util.*;

public class no3 {

    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int delay = -1;

        //사람이 추가되는 전체 시간 = k*order.length;
        //시간을 순회하면서 처리하면...?
        int idx = 0;
        for(int time=0; time<=k*order.length; time++) {

            //k 시간 마다 마다 사람 추가
            if(idx<order.length && k*idx==time){
                queue.offer(order[idx]);
                idx++;
            }

            //주문 처리가 끝나면,
            //delay 초기화 시켜 주고 대기 목록 에서 손님 제거
            if(delay==time){
                queue.poll();
                delay = -1;
            }

            //주문을 받을 수 있는 상태 이면
            if(delay==-1 && !queue.isEmpty()){
                delay = time + menu[queue.peek()];
            }

            answer = Math.max(answer, queue.size());
        }

        return answer;
    }
}
