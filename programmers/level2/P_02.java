package com.study.codingtest.programmers.level2;

public class P_02 {
    /*
    숫자의 표현
     */

    static int count = 0;

    static void dfs(int start, int sum, int target) {

        if(sum == target) {
            count++;
            return;
        }

        if(sum>target)
            return;

        dfs(start+1, sum+start, target);
    }

    static int solution(int n) {

        for(int i=1; i<=n; i++)
            dfs(i, 0, n);

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
