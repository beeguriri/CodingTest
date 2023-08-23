package com.study.codingtest.programmers.level3;

import java.util.*;

public class P_12 {

    /*
        가장 먼 노드
        가장 먼 노드의 개수 찾기
     */

    static class Node implements Comparable<Node> {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }

        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static final int INF = (int) 1e9;
    public static List<ArrayList<Node>> list = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getNode();
            int distance = node.getDistance();

            if(d[now] < distance)
                continue;

            for(int i=0; i<list.get(now).size(); i++) {
                int next = list.get(now).get(i).getNode();
                int cost = list.get(now).get(i).getDistance() + d[now];

                if(cost<d[next]) {
                    d[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }
    }

    public static int solution(int n, int[][] edge) {

        int answer = 0;

        d = new int [n+1];
        Arrays.fill(d, INF);

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int [] e : edge) {
            //양방향
            list.get(e[0]).add(new Node(e[1], 1));
            list.get(e[1]).add(new Node(e[0], 1));
        }

        dijkstra(1);

        int max = 0;
        for(int i=1; i<=n; i++)
            max = Math.max(max, d[i]);

        for(int i=1; i<=n; i++)
            if(max==d[i])
                answer++;

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(6, new int [][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); //3

    }
}
