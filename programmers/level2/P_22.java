package com.study.codingtest.programmers.level2;

/*
피로도 - dfs
["최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.] 의 조건에 의해
피로도가 0 이하로 내려가는 케이스 생각 안해도 됨
 */

public class P_22 {

    static boolean [] check;
    static int answer = 0;

    static void dfs(int depth, int k, int[][] dungeons) {

        //순열로 구하기
        for(int i=0; i<dungeons.length; i++) {

            if(k<dungeons[i][0])
                continue;

            if(!check[i]) {
                check[i] = true;
                dfs(depth+1, k-dungeons[i][1], dungeons);
                check[i] = false;
            }
        }

        answer = Math.max(answer, depth);

    }

    public int solution(int k, int[][] dungeons) {

        check = new boolean [dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

}
