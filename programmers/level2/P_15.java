package com.study.codingtest.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P_15 {

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();

        if(cacheSize==0)
            return cities.length*5;

        for(String s : cities) {
            s = s.toLowerCase();

            if(que.contains(s)) {
                que.remove(s);
                que.offer(s);
                answer+=1;
            }
            //포함 안되어있을때
            else {
                //큐 공간 있으면 그냥 추가
                if(que.size()<cacheSize) {
                    que.offer(s);
                }
                //아니면 젤 처음 들어온거 빼고 추가
                else {
                    que.poll();
                    que.offer(s);
                }
                answer+=5;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(3, new String [] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
