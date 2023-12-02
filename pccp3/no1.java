package com.study.codingtest.pccp3;

import java.util.LinkedList;
import java.util.Queue;

public class no1 {

    public int solution(int[] bandage, int health, int[][] attacks) {

        int time = 1; //현재 시간
        int now = health; //현재 체력
        int count = 1; //연속 으로 기술 시전한 시간

        Queue<int []> queue = new LinkedList<>();

        for(int [] attack : attacks)
            queue.offer(attack);

        while(!queue.isEmpty()){

            //공격이 있는지 확인
            //공격이 없으면 아래 로직 수행
            if(queue.peek()[0]!=time) {

                now = Math.min(now + bandage[1], health);
                System.out.println("count: " + count);
                if(count==bandage[0]){
                    now = Math.min(now + bandage[2], health);
                    count = 0;
                }
                time++;
                count++;

            } else {
                //현재 시간이 공격 시간이 되면, 기술 시전 시간 초기화 하고, 체력 깎아줌.
                int [] attk = queue.poll();
                now = now - attk[1];
                count = 1;
                time++;
            }

            //이때 체력이 0 보다 작거나 같으면 while 문에서 빠져 나옴
            if(now<=0){
                now = -1;
                break;
            }
        }
        return now;
    }
}
