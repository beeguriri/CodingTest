package com.study.codingtest.baekjoon.greedy;

import java.util.Scanner;

public class B_2839 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();
        int sum = 0;

        while(sugar>0) {
            if(sugar%5==0){
                sum += sugar/5;
                break;
            } else if(sugar>=3){
                sugar -= 3;
                sum++;
            } else {
                sum = -1;
                break;
            }
        }

        System.out.println(sum);
    }
}
