package com.study.codingtest.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
30
=> 0이 포함안되어있으면 false
=> 각 자리 더한 값이 3의 배수가 아니면 false
=> 각 자리 내림차순으로 합하기
 */
public class B_10610 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(!str.contains("0")) {
            System.out.println("-1");
            return;
        }

        String [] temp = str.split("");
        int sum = 0;
        for(String s : temp)
            sum += Integer.parseInt(s);

        if(sum%3!=0) {
            System.out.println("-1");
            return;
        }
        Arrays.sort(temp);
        StringBuilder sb = new StringBuilder();
        for(int i=temp.length-1; i>=0; i--)
            sb.append(temp[i]);

        System.out.println(sb);
    }
}
