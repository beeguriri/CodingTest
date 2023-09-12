package com.study.codingtest.programmers.level2;

/*
예상 대진표
 */
public class P_08 {
    public int solution(int n, int a, int b) {
        
        int answer = 0;

        //홀수면 +1 해서 /2, 짝수면 /2
        while(a!=b) {
            a = a%2==0 ? a/2 : (a+1)/2;
            b = b%2==0 ? b/2 : (b+1)/2;
            answer++;
        }

        return answer;
    }
}
