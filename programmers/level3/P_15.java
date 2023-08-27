package com.study.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_15 {

    /*
    여행 경로
     */

    static List<String> list = new ArrayList<>();
    static boolean [] check;

    static void dfs(int depth, String start, String result, String [][] tickets) {

        //dfs 종료 조건
        if(depth==tickets.length) {
            list.add(result);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(!check[i] && start.equals(tickets[i][0])){
                check[i] = true;
                dfs(depth+1, tickets[i][1], result+" "+tickets[i][1], tickets);
                check[i] = false;
            }
        }

    }

    public static String [] solution(String[][] tickets) {

        check = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String [][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(solution(new String [][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));

    }
}
