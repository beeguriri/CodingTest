package com.study.codingtest.programmers.level1;

public class P_02 {

    static int answer = 0;

    static void dfs(int [] number, boolean [] check, int start, int depth) {

        //dfs 종료 조건
        if(depth==3) {
            int result = 0;
            for(int i=0; i<number.length; i++)
                if(check[i])
                    result += number[i];
            if(result==0)
                answer++;
        }

        for(int i=start; i<number.length; i++){
            check[i] = true;
            dfs(number, check, i+1, depth+1);
            check[i] = false;
        }
    }

    static int solution(int[] number) {
        dfs(number, new boolean [number.length], 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {-2, 3, 0, 2, -5}));
    }
}
