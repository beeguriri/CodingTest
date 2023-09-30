package com.study.codingtest.programmers.level2;

import java.util.*;

/*
배달
 */
public class P_61 {

    static final int INF = (int)1e9;
    static List<ArrayList<int []>> list = new ArrayList<>();
    static int [] d;

    static void djikstra(int start, int K) {

        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {start, 0});
        d[start] = 0;

        while(!pq.isEmpty()){

            int [] node = pq.poll();
            int now = node[0];
            int dist = node[1];

            if(d[now]<dist)
                continue;

            for(int i=0; i<list.get(now).size(); i++){
                int idx = list.get(now).get(i)[0];
                int cost = d[now] + list.get(now).get(i)[1];

                if(cost < d[idx] && cost <=K){
                    d[idx] = cost;
                    pq.offer(new int [] {idx, cost});
                }
            }
        }
    }


    public int solution(int N, int[][] road, int K) {

        int answer = 0;

        d = new int [N+1];
        Arrays.fill(d, INF);

        //인접리스트 입력
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int [] i : road){
            list.get(i[0]).add(new int [] {i[1], i[2]});
            list.get(i[1]).add(new int [] {i[0], i[2]});
        }

        //다익스트라 알고리즘 수행
        //1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수
        djikstra(1, K);

        //d 배열 확인
        for(int i : d)
            if(i!=INF)
                answer++;

        return answer;
    }
}
