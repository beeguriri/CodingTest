package com.study.codingtest.programmers.level2;

/*
점찍기
 */

public class P_67 {

    public long solution(int k, int d) {
        long answer = 0;
        //d^2 = x^2 + y^2
        //y = (long) Math.sqrt(d^2-x^2)
        for(int i=0; i<=d; i+=k){
            long y = (long)Math.sqrt(Math.pow(d,2)-Math.pow(i,2));
            answer += (y/k)+1;
        }

        return answer;
    }
}
