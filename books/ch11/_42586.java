package com.study.codingtest.books.ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _42586 {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> que = new LinkedList<>();

        //완성까지 걸리는 시간을 먼저 계산하고 큐에 전부 넣기
        //(먼저 넣은것 부터 확인할거니까)
        for(int i=0; i<progresses.length; i++){
            double remains = Math.ceil(((double)100 - progresses[i])/speeds[i]);
            // System.out.println(remains);
            que.offer((int)remains);
        }

        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){

            int count = 1;
            int now = que.poll();

            while(!que.isEmpty() && que.peek()<=now){
                que.poll();
                count++;
            }

            list.add(count);
        }

        // System.out.println(list);

        return list.stream().mapToInt(i->i).toArray();
    }
}
