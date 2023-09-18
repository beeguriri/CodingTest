package com.study.codingtest.programmers.level2;

import java.util.*;
/*
기능 개발
 */
public class P_19 {

    public int[] solution(int[] progresses, int[] speeds) {

        //작업에 필요한 일수 넣어놓기
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            double time = Math.ceil((double)(100-progresses[i])/speeds[i]);
            queue.offer((int)time);
        }
        System.out.println(queue);

        //큐가 빌때까지 확인
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            int time = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && queue.peek()<=time){
                queue.poll();
                count++;
            }
            list.add(count);
        }
        System.out.println(list);

        return list.stream().mapToInt(i->i).toArray();
    }
}
