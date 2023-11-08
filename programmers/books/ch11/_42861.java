package com.study.codingtest.programmers.books.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _42861 {

    static class Edge implements Comparable<Edge> {

        int nodeA;
        int nodeB;
        int distance;

        public Edge(int nodeA, int nodeB, int distance){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        //거리 짧은 순으로 정렬
        public int compareTo(Edge e){
            return this.distance - e.distance;
        }
    }

    static int [] parents;
    static List<Edge> list = new ArrayList<>();

    static int findParents(int x){
        if(x==parents[x])
            return x;

        return parents[x] = findParents(parents[x]);
    }

    static void unionParents(int a, int b){
        a = parents[a];
        b = parents[b];

        if(a<b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        //부모 배열 초기화
        parents = new int [n+1];
        for(int i=1; i<=n; i++)
            parents[i] = i;

        //간선 정보 입력
        for(int [] cost : costs)
            list.add(new Edge(cost[0], cost[1], cost[2]));

        //거리 기준 오름차순 정렬
        Collections.sort(list);

        for(Edge e : list){
            int a = e.nodeA;
            int b = e.nodeB;
            int c = e.distance;

            if(findParents(a)==findParents(b))
                continue;

            unionParents(a, b);
            answer += c;
        }

        return answer;
    }
}
