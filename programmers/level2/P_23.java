package com.study.codingtest.programmers.level2;

/*
타겟넘버
dfs 종료조건 잘 생각하기!
 */
public class P_23 {

    //타겟 넘버를 만드는 방법의 수를 return
    static int answer = 0;

    static void dfs(int depth, int sum, int target, int [] numbers) {

        //dfs 종료조건
        //맨 처음값을 sum에 넣고 시작했으므로 length-1
        if(depth==numbers.length-1){
            if(sum==target)
                answer++;
            return;
        }

        dfs(depth+1, sum+numbers[depth+1], target, numbers);
        dfs(depth+1, sum-numbers[depth+1], target, numbers);

    }

    public int solution(int[] numbers, int target) {

        //맨 처음값을 sum에 넣고 시작
        dfs(0, numbers[0], target, numbers);
        dfs(0, -1*numbers[0], target, numbers);

        return answer;
    }
}
