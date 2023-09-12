package com.study.codingtest.programmers.level2;

/*
N개의 최소공배수
 */
public class P_09 {

    static long gcd(long a, long b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public long solution(int[] arr) {
        //최대공약수 구해서
        //전부 나눠준 후
        //최대공약수 * 나눈수 ?
        long answer = arr[0];
        for(long i : arr) {
            long num = gcd(answer, i);
            answer *= (i/num);
        }

        return answer;
    }
}
