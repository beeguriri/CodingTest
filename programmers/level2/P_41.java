package com.study.codingtest.programmers.level2;

/*
2개 이하로 다른 비트
 */

public class P_41 {
    public long[] solution(long[] numbers) {
        long[] answer = new long [numbers.length];

        for(int i=0; i<numbers.length; i++) {


            //짝수이면 맨 뒷자리를 1로 바꿔줌
            if(numbers[i]%2==0)  {
                answer[i] = numbers[i]+1;
            }
            //홀수이면
            else {

                String now = Long.toString(numbers[i], 2);

                //0이 없을 경우 제일 처음 나오는 1을 "10"으로
                if(!now.contains("0")) {
                    now = now.replaceFirst("1", "10");
                }
                //뒤에서부터 제일 처음 나오는 0을 1로, 그 뒷자리를 0으로
                else {
                    int idx = now.lastIndexOf("0");
                    now = now.substring(0, idx) + "10" + now.substring(idx+2);
                }
                answer[i] = Long.parseLong(now, 2);
            }

        }

        return answer;
    }
}
