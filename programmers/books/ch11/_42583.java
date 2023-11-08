package com.study.codingtest.programmers.books.ch11;

import java.util.LinkedList;
import java.util.Queue;

public class _42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        //들어간 순서대로 나와야 하므로 queue 사용
        Queue<Integer> que = new LinkedList<>();

        int time = 0;
        int sum = 0;

        //truck의 무게가 weight보다 작거나 같을때만 올릴 수 있음
        //truck의 댓수가 length보다 작아야 함
        for(int truck : truck_weights) {

            while(true) {

                //큐가 비어있으면 트럭이 없으므로 트럭을 다리에 올림
                if(que.isEmpty()){
                    que.offer(truck);
                    sum += truck;
                    time++;
                    break;
                }
                //다리의 길이와 que의 사이즈가 같으면 트럭 제거
                else if (que.size()==bridge_length){
                    sum -= que.poll();
                }
                //다음 트럭이 들어올려고 할때
                else {
                    //다음 트럭의 무게를 더해보고, weight보다 크면 대기해야 함
                    //아니면 que에 넣기
                    if(sum+truck>weight){
                        que.offer(0);
                        time++;
                    } else {
                        que.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }
        }

        return time+bridge_length;
    }
}
