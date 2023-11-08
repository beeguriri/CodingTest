package com.study.codingtest.programmers.books.ch11;

import java.util.Arrays;

public class _49191 {

    private final int INF = (int)1e9;

    public int solution(int n, int[][] results) {
        int answer = 0;
        int [][] graph = new int [n+1][n+1];

        //무한대로 채워놓고
        for(int [] g : graph)
            Arrays.fill(g, INF);

        //자기 자신은 0
        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j) graph[i][j] = 0;

        //그래프 입력
        //1이 이김, -1이 짐
        for(int [] result : results){
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }


        for(int k=1; k<=n; k++){
            for(int a=1; a<=n; a++){
                for(int b=1; b<=n; b++){

                    //a가 k한테 이기고, k가 b한테 이겼으면,
                    //a는 b한테 이김
                    if(graph[a][k]==1 && graph[k][b]==1) {
                        graph[a][b] = 1;
                        graph[b][a] = -1;
                    }
                    //a가 k한테 지고, k가 b한테 지면
                    //a가 b한테 짐
                    else if(graph[a][k]==-1 && graph[k][b]==-1) {
                        graph[a][b] = -1;
                        graph[b][a] = 1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j]!=INF)
                    count++;
            }
            if(count==n)
                answer++;
        }

        return answer;
    }
}
