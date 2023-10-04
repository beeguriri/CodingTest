package com.study.codingtest.baekjoon.dp;

import java.util.Scanner;

/*
피보나치 함수
0의 개수 : 0일때 1, 1일때 0, 2일때 1, 3일때 1, 4일때 2, ... 6일때 5
1의 개수 : 0일때 0, 1일때 1, 2일때 1, 3일때 2, 4일때 3,...  6일때 8
 */

public class B_1003 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int [] count0 = new int [41];
        int [] count1 = new int [41];

        count0[0] = 1; count0[1] = 0;
        count1[0] = 0; count1[1] = 1;

        for(int i=2; i<=40; i++){
            count0[i] = count0[i-2] + count0[i-1];
            count1[i] = count1[i-2] + count1[i-1];
        }

        for(int i=0; i<c; i++) {
            int n = sc.nextInt();
            System.out.printf("%d %d\n", count0[n], count1[n]);
        }

    }
}
