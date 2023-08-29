package com.study.codingtest.baekjoon.string;

import java.util.Scanner;

public class B_1254 {

    /*
    팰린드롬 만들기
    팰린드롬에 해당되는 문자열 찾을때까지 for문 돌아서
    팰린드롬 찾으면 해당 인덱스에서부터 처음 인덱스까지 다 붙여줌
     */

    static boolean isPal(String s) {

        int first = 0;
        int last = s.length()-1;

        while(first<=last)
            if (s.charAt(first++)!=s.charAt(last--))
                return false;

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int answer = s.length();
        for(int i=0; i<s.length(); i++)
            if(isPal(s.substring(i)))
               break;
            else
                answer++;

        System.out.println(answer);
    }
}
