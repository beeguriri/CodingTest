package com.study.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P_03 {
    public static int[] solution(int N, int[] stages) {

        int[] answer = new int [N];

        double [][] result = new double [N][2];
        for(int i=0; i<N; i++)
            result[i][0] = i+1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : stages)
            pq.offer(s);

        while(!pq.isEmpty()) {

            int size = pq.size();
            int now = pq.poll();
            int count = 1;

            if(now==N+1)
                break;

            while(!pq.isEmpty() && pq.peek()==now){
                pq.poll();
                count++;
            }

            System.out.println(count);
            result[now-1][1] = (double)count/size;

        }

        Arrays.sort(result, (o1, o2) ->
                o1[1] > o2[1] ? -1 :
                        o1[1] < o2[1] ? 1 :
                                o1[0] < o2[0] ? -1 : 1);

        for(int i=0; i<N; i++)
            answer[i] = (int) result[i][0];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, new int [] {4, 4, 4, 4, 4})));
        System.out.println(Arrays.toString(solution(5, new int [] {3, 2, 1, 1})));
        System.out.println(Arrays.toString(solution(10, new int [] {10, 2})));
        System.out.println(Arrays.toString(solution(5, new int [] {2, 4})));
        System.out.println(Arrays.toString(solution(5, new int [] {3, 3, 3, 3, 3})));


    }
}
