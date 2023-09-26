package com.study.codingtest.programmers.level2;

import java.util.*;
/*
두 큐의 합 같게 만들기
 */

public class P_49 {

    public int solution(int[] queue1, int[] queue2) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        int length = (queue1.length+1)*2; //(큐의길이 + 공백) * 2번 왕복
        int count = 0;
        long sum1 = 0;
        long sum2 = 0;

        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        while((!q1.isEmpty() || !q2.isEmpty()) && length>=0) {

            if(sum1 == sum2)
                return count;

            //sum1에서 pop
            if(sum1>sum2 && !q1.isEmpty()) {
                int x = q1.poll();
                q2.offer(x);
                sum1 -= x;
                sum2 += x;
            }
            //sum2에서 pop
            else if(sum1<sum2 && !q2.isEmpty()) {
                int x = q2.poll();
                q1.offer(x);
                sum1 += x;
                sum2 -= x;
            }

            count++;
            length--;

        }

        return -1;
    }
}
