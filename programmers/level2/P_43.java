package com.study.codingtest.programmers.level2;

import java.util.*;
/*
다리를 지나는 트럭
 */

public class P_43 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int time = 0;

        //대기트럭
        //bridge_length만큼 시간 경과
        //weight 만큼 트럭 올라 갈 수 있음
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(int i : truck_weights) {
            while(true){
                if(queue.isEmpty()) {
                    queue.offer(i);
                    sum += i;
                    time++;
                    break;
                }
                //다리위에는 다리길이만큼의 트럭만 올라갈 수 있음
                else if(queue.size()==bridge_length) {
                    sum -= queue.poll();
                }
                else {
                    if(sum+i<=weight){
                        queue.offer(i);
                        sum += i;
                        time++;
                        break;
                    } else {
                        //공백 넣어주기
                        queue.offer(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}
