package com.study.codingtest.programmers.level2;

public class P_13 {
    
    public static int[] solution(int n, long left, long right) {

        int[] answer = new int [(int)(right-left)+1];
        //[123,223,333]
        //[1234,2234,3334,4444]
        for(int i=0; i<answer.length; i++) {
            answer[i] = (int)Math.max(left/n, left%n)+1;
            left++;
        }

        return answer;
    }
}
