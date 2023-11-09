package com.study.codingtest.books.ch12;

public class _43162_1 {

    static boolean [] check;

    static void dfs(int node, int [][] computers){

        check[node] = true;

        for(int i=0; i<computers.length; i++)
            if(!check[i] && computers[node][i]==1)
                dfs(i, computers);

    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean [n];

        for(int i=0; i<n; i++){
            if(!check[i]){
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }
}
