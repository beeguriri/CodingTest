package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2252 {

    /*
    줄 세우기
    위상 정렬 문제?
    진입 차수가 0인것 부터 시작
    노드 제거 후 degree 하나 빼줌
    N명의 학생, M번의 비교
    A B => A가 B보다 앞서야 함
     */

    static int n, m;
    static int [] degree;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void topologySort() {

        Queue<Integer> queue = new LinkedList<>();

        //진입 차수가 0인 노드 queue 에 넣기
        for(int i=1; i<=n; i++)
            if(degree[i]==0)
                queue.offer(i);

        while(!queue.isEmpty()) {

            int now = queue.poll();
            result.add(now);

            for(int i=0; i<list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                degree[next] -= 1;

                if(degree[next]==0)
                    queue.offer(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        degree = new int [n+1];
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            degree[b] += 1;
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        for(int i : result)
            sb.append(i).append(" ");

        System.out.println(sb);
    }
}
