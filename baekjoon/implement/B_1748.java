package com.study.codingtest.baekjoon.implement;

import java.util.Scanner;

public class B_1748 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;
        int digit = 1; //자릿수
        int divider = 10; //1, 10, 100의 자리 파악

        for(int i=1; i<=n; i++){
            //자릿수 변경 조건
            if(i%divider==0) {
                digit += 1;
                divider *= 10;
            }
            count += digit;
        }

        System.out.println(count);
    }
}
