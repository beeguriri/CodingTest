package com.study.codingtest.programmers.level2;

import java.util.*;

/*
전력망 둘로 나누기
인접리스트 형태로 넣어놓고 하나씩 끊어가면서
dfs로 개수 세어야 할 듯?
두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return
 */

public class P_55 {

    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int count = 0;

    static void dfs(int node, boolean [] check){

        check[node] = true;
        count++;
        for(int i : list.get(node)){
            if(!check[i])
                dfs(i, check);
        }
    }

    public int solution(int n, int[][] wires) {

        int answer = 100;

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        //전력망 입력하기
        for(int [] wire : wires){
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        // for(ArrayList<Integer> l : list)
        //     System.out.println(l);

        //전력망 하나씩 끊으면서 확인
        for(int [] wire : wires) {
            list.get(wire[0]).remove(new Integer(wire[1]));
            list.get(wire[1]).remove(new Integer(wire[0]));

            count=0;
            dfs(wire[0], new boolean[n+1]);
            answer = Math.min(answer, Math.abs(n-2*count));

            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        return answer;
    }
}
