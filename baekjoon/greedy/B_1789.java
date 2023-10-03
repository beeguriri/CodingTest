package com.study.codingtest.baekjoon.greedy;

import java.util.Scanner;

/*
수들의 합
서로 다른 N개의 자연수의 합이 S라고 한다.
S를 알 때, 자연수 N의 최댓값은 얼마일까?
=> 1부터 더해주기 시작해서
=> 최대값을 넘어가면 count에서 하나 빼주면 됨
첫째 줄에 자연수 S(1 ≤ S ≤ 4,294,967,295)가 주어진다.
=> 범위때문에 long 형으로 선언
 */
public class B_1789 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long sum = 0;
        int count = 0;
        for(long i=1; i<=N; i++){
            sum += i;
            count++;
            if(sum>=N)
                break;
        }

        if(sum==N)
            System.out.println(count);
        else
            System.out.println(count-1);
    }
}
