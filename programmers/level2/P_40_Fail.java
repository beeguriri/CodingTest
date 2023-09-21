package com.study.codingtest.programmers.level2;

/*
숫자 변환하기
재귀로 풀고싶었는데...
호출 횟수에 따른 제약이 있다고 해서...
 */
public class P_40_Fail {

    static int count = Integer.MAX_VALUE;

    static void dfs(long number, int depth, int target, int n) {

        //종료조건
        if(number>=target) {
            if(number>target)
                return;

            count = Math.min(count, depth);
            return;

        }

        dfs(number+n, depth+1, target, n);
        dfs(number*2, depth+1, target, n);
        dfs(number*3, depth+1, target, n);
    }

    public int solution(int x, int y, int n) {

        dfs((long)x+n, 1, y, n);
        dfs((long)x*2, 1, y, n);
        dfs((long)x*3, 1, y, n);

        return count==Integer.MAX_VALUE ? -1 : count;
    }
}
