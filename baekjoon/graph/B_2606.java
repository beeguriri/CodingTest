package com.study.codingtest.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
바이러스
1번 컴퓨터에서 시작해서
연결된 갯수 확인 => dfs로 푸는게 나은가
 */
public class B_2606 {

    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int node, edge;
    static boolean [] check;
    static int count = -1; //시작번호 1번은 카운트 안해줌

    static void dfs(int node){
        if(check[node])
            return;

        check[node] = true;
        count++;

        for(int i=0; i<list.get(node).size(); i++){
            if(!check[list.get(node).get(i)])
                dfs(list.get(node).get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        check = new boolean[node+1];

        for(int i=0; i<=node; i++)
            list.add(new ArrayList<>());

        //무방향 그래프 입력
        for(int i=0; i<edge; i++){
            String temp = br.readLine();
            int a = Integer.parseInt(temp.split(" ")[0]);
            int b = Integer.parseInt(temp.split(" ")[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        //1번에서부터 연결여부 확인
        dfs(1);
        System.out.println(count);
    }
}
