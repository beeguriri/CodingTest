package com.study.codingtest.baekjoon.bruteforce;

import java.util.Scanner;

/*
한수
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면,
그 수를 한수라고 한다.
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.\
1~99까지는 모두 한수
100부터 비교해주기
 */
public class B_1065 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        if(n<100) {
            count = n;
        } else {
            count = 99;

            for(int i=100; i<=n; i++){
                String num = String.valueOf(i);
                if(num.charAt(0)-num.charAt(1) == num.charAt(1)-num.charAt(2))
                    count++;
            }
        }

        System.out.println(count);
    }
}
