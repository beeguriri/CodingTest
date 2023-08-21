package com.study.codingtest.programmers.level3;

import java.util.Arrays;

public class P_03 {

    public static int[] solution(int n, int s) {

        if (n>s)
            return new int [] {-1};

        int [] answer = new int [n];

        int idx = 0;
        while(s>0){
            int num = s/n;
            answer[idx++] = num;
            s -= num;
            n--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
    }
}
