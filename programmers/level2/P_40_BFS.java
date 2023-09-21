package com.study.codingtest.programmers.level2;

import java.util.*;

/*
숫자 변환하기
bfs로 풀기
*/

public class P_40_BFS {

    static int answer = Integer.MAX_VALUE;

    static void bfs(int number, int target, int n) {

        Queue<int []> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>(); //중복 확인용

        queue.offer(new int [] {number, 0});
        set.add(number);

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            if(now[0]==target)
                answer = Math.min(answer, now[1]);

            if(now[0]>target)
                continue;

            if(now[0]+n <=target && !set.contains(now[0]+n)){
                queue.offer(new int [] {now[0]+n, now[1]+1});
                set.add(now[0]+n);
            }

            if(now[0]*2 <=target && !set.contains(now[0]*2)){
                queue.offer(new int [] {now[0]*2, now[1]+1});
                set.add(now[0]*2);
            }

            if(now[0]*3 <=target && !set.contains(now[0]*3)){
                queue.offer(new int [] {now[0]*3, now[1]+1});
                set.add(now[0]*3);
            }
        }

    }

    public int solution(int x, int y, int n) {

        bfs(x, y, n);

        return answer==Integer.MAX_VALUE ? -1 : answer;
    }
}
