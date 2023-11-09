package com.study.codingtest.books.ch12;

public class _43165 {

    static int count = 0;

    static void dfs(int depth, int start, int sum, int [] numbers, int target) {

        //종료 조건
        if(depth==numbers.length){
            if(sum==target)
                count++;
            return;
        }

        for(int i=start; i<numbers.length; i++){
            dfs(depth+1, i+1, sum+numbers[depth], numbers, target);
            dfs(depth+1, i+1, sum-numbers[depth], numbers, target);
        }

    }

    public int solution(int[] numbers, int target) {

        dfs(0, 0, 0, numbers, target);

        return count;
    }
}
