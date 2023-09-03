package com.study.codingtest.programmers.level1;

public class P_01 {

    static int solution(int n) {

        String temp = Integer.toString(n, 3);

        StringBuilder sb = new StringBuilder();

        for(int i=temp.length()-1; i>=0; i--)
            sb.append(temp.charAt(i));

        return Integer.parseInt(sb.toString(), 3);
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));

    }
}
