package com.study.codingtest.baekjoon.string;

import java.util.Scanner;

public class B_1439 {

    /*
    뒤집기
    연속된 하나 이상의 숫자를 잡고 모두 뒤집기
    연속된 1의 영역, 연속된 0의 영역 개수를 찾아서
    둘중 값이 작은 것을 뒤집으면 되지 않을까?
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char now = s.charAt(0);
        int num0 = now == '0' ? 1 : 0;
        int num1 = now == '1' ? 1 : 0;

        for(int i=1; i<s.length(); i++) {

            if(s.charAt(i) == now)
                continue;

            now = s.charAt(i);

            if(now == '0')
                num0++;
            else
                num1++;

        }

        System.out.println(Math.min(num0, num1));

    }
}
