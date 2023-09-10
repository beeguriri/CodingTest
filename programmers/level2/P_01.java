package com.study.codingtest.programmers.level2;

/*
이진변환 반복하기
 */

public class P_01 {
    static int countZero(String s) {

        int count = 0;
        for(char c : s.toCharArray())
            if(c=='0')
                count++;

        return count;
    }

    public int[] solution(String s) {
        //이진변환의 횟수, 제거 된 0의 갯수
        int count = 0;
        int sum = 0;

        while(!s.equals("1")) {
            sum += countZero(s);
            s = s.replaceAll("[0]+", "");
            s = Integer.toString(s.length(), 2);
            count++;
        }

        return new int [] {count, sum};
    }

    public static void main(String[] args) {
        
    }
}
