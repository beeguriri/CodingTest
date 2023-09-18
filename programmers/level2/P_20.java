package com.study.codingtest.programmers.level2;

import java.util.*;
/*
프로세스
 */
public class P_20 {

    public int solution(int[] priorities, int location) {

        //큐에 [location, priorities] 배열로 넣어놓고
        //리스트 순회하면서,
        //우선순위 높은게 있으면 offer()
        //아니면 poll(), 하면서 그때의 순서를 새로운 배열에 기록
        int [] result = new int [priorities.length];
        Queue<int []> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++)
            queue.offer(new int [] {i, priorities[i]});

        int order = 1;
        while(!queue.isEmpty()) {

            //리스트 끝까지 순회했는지 확인용
            boolean flag = true;

            int [] now = queue.poll();

            for(int [] list : queue) {
                System.out.println(Arrays.toString(list));
                if(now[1]<list[1]){
                    queue.offer(now);
                    flag = false;
                    break;
                }
            }

            if(flag)
                result[now[0]] = order++;
        }

        System.out.println(Arrays.toString(result));

        return result[location];
    }
}
