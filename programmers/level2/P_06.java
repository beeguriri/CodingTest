package com.study.codingtest.programmers.level2;

import java.util.Arrays;

/*
구명보트
 */

public class P_06 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        //최대 2명 탄다고 했으므로
        //몸무게 제일 작은사람이랑 큰사람이랑 태워보고,
        //limit 초과하면 count++ 해주면 되지 않을까?
        int pl = 0;
        int pr = people.length-1;

        Arrays.sort(people);

        while(pl<=pr) {
            if(people[pl]+people[pr]<=limit) {
                answer++;
                pl++;
                pr--;
            } else {
                answer++;
                pr--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
