package com.study.codingtest.programmers.level2;

/*
마법의 엘리베이터
나머지가 5보다 크면? 더하기
나머지가 5보다 작으면? 빼기
나머지가 5일때는 앞자리 까지 비교하기
 */
public class P_62 {

    public int solution(int storey) {
        int answer = 0;
        while(storey>0) {

            if(storey%10 >5) {
                answer += 10-storey%10;
                storey += 10-storey%10;
            } else if(storey%10<5) {
                answer += storey%10;
                storey -= storey%10;
            } else {
                if(storey%100>50){
                    answer += 5;
                    storey += 5;
                } else {
                    answer += 5;
                    storey -= 5;
                }
            }
            storey /= 10;
        }

        return answer;
    }
}
