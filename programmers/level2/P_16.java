package com.study.codingtest.programmers.level2;

import java.util.Arrays;

public class P_16 {

    static int solution(int[] citations) {
        int answer = 0;


        Arrays.sort(citations);

        //h편 : h<=citations.length;
        for(int i=0; i<=citations.length; i++) {
            int count = 0;
            //i번 이상 인용 된 횟수 count
            for(int j=0; j<citations.length; j++) {
                if(citations[j]>=i)
                    count++;
            }
            //h번 이상 인용된 논문이 h편,
            //나머지는 h번 이하 인용되어야 함
            if(count>=i && citations.length-count<=i)
                answer = Math.max(answer, i);

        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
