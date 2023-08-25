package com.study.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_13 {

    /*
    섬 연결 하기
    n개의 섬 사이에 다리를 건설 하는 비용(costs)이 주어질 때,
    최소의 비용으로 모든 섬이 서로 통행 가능 하도록 만들 때
    필요한 최소 비용을 return 하도록 solution을 완성하세요.
     */

    static class Edge implements Comparable<Edge> {

        private final int nodeA;
        private final int nodeB;
        private final int distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static int [] parent;
    public static List<Edge> edges = new ArrayList<>();

    public static int findParent(int x) {

        if(x==parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = parent[a];
        b = parent[b];

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static int solution(int n, int[][] costs) {

        int answer = 0;

        //부모 배열 초기화
        parent = new int [n+1];
        for(int i=0; i<=n; i++)
            parent[i] = i;

        //간선 정보 입력
        for(int [] cost : costs)
            edges.add(new Edge(cost[0], cost[1], cost[2]));

        //거리에 대해 오름차순 정렬
        Collections.sort(edges);

        //각 간선에 대해서 확인
        for(int i=0; i<costs.length; i++) {
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            if(findParent(a)!=findParent(b)) {
                unionParent(a, b);
                answer += edges.get(i).getDistance();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int [][] {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
    }
}
