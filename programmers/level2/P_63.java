package com.study.codingtest.programmers.level2;

/*
숫자 카드 나누기
 */

public class P_63 {

    static int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        //arrayA의 gcd를 구하고, 그걸로 arrayB를 나눌 수 없는 수
        int gcdA = arrayA[0];
        boolean flagB = true;

        for(int i=1; i<arrayA.length; i++)
            gcdA = gcd(gcdA, arrayA[i]);

        for(int i : arrayB){
            if(i%gcdA==0){
                flagB = false;
                break;
            }
        }

        //arrayB의 gcd를 구하고, 그걸로 arrayA를 나눌 수 없는 수
        int gcdB = arrayB[0];
        boolean flagA = true;

        for(int i=1; i<arrayB.length; i++)
            gcdB = gcd(gcdB, arrayB[i]);

        for(int i : arrayA) {
            if(i%gcdB==0){
                flagA = false;
                break;
            }
        }

        if(!flagA && !flagB)
            return 0;
        else if(flagA && !flagB)
            return gcdB;
        else if (!flagA && flagB)
            return gcdA;
        else
            return Math.max(gcdA, gcdB);

    }
}
