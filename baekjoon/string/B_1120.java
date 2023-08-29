package com.study.codingtest.baekjoon.string;

import java.util.Scanner;

public class B_1120 {
    /*
    문자열
    A의 길이만큼 B를 옮겨다니면서
    차이 계산해서 최소값 리턴??
     */

    static int countDiff(String a, String b) {

        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int count = a.length();
        for(int i=0; i<b.length()-a.length()+1; i++)
            count = Math.min(count, countDiff(a, b.substring(i, i+a.length())));

        System.out.println(count);
    }
}
