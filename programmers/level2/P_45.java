package com.study.codingtest.programmers.level2;

import java.util.*;

/*
소수 찾기
 */

public class P_45 {
    static Set<Integer> set = new HashSet<>();

    static void makePrime(int depth, String s1, String [] num, boolean [] check) {

        //종료조건
        if(depth>num.length)
            return;

        if(!s1.isEmpty() && isPrime(Integer.parseInt(s1)))
            set.add(Integer.parseInt(s1));

        //중복 허용 안하는 순열
        for(int i=0; i<num.length; i++){
            if(!check[i]) {
                check[i] = true;
                makePrime(depth+1, s1+num[i], num, check);
                check[i] = false;
            }
        }

    }

    static boolean isPrime(int num) {

        if(num<=1)
            return false;

        for(int i=2; i<=Math.sqrt(num); i++)
            if(num%i==0)
                return false;

        return true;
    }

    public int solution(String numbers) {
        int answer = 0;
        String [] num = numbers.split("");
        boolean [] check = new boolean [numbers.length()];

        makePrime(0, "", num, check);
        // System.out.println(set);

        return set.size();
    }
}
