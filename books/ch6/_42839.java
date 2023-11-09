package com.study.codingtest.books.ch6;

import java.util.HashSet;
import java.util.Set;

public class _42839 {

    //모든 숫자 순열을 만들어서
    //소수이면 set에 추가하기
    static Set<Integer> set = new HashSet<>();

    static void makePrime(int depth, String prime, String[] number, boolean [] check) {

        //종료조건
        if(depth>number.length)
            return;

        if(!prime.isEmpty() && isPrime(Integer.parseInt(prime)))
            set.add(Integer.parseInt(prime));

        for(int i=0; i<number.length; i++) {
            if(!check[i]){
                check[i] = true;
                makePrime(depth+1, prime+number[i], number, check);
                check[i] = false;
            }
        }
    }

    static boolean isPrime(int x){

        if(x<=1)
            return false;

        for(int i=2; i<=Math.sqrt(x); i++)
            if(x%i==0)
                return false;

        return true;
    }

    public int solution(String numbers) {

        String [] number = numbers.split("");
        boolean [] check = new boolean [number.length];

        makePrime(0, "", number, check);
        // System.out.println(set);

        return set.size();
    }
}
