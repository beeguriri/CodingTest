package com.study.codingtest.programmers.level1;

public class P_08 {

    public static int solution(String s) {
        int answer = 0;

        char start = s.charAt(0);
        int countA = 1;
        int countB = 0;
        boolean flag = false;

        for(int i=1; i<s.length(); i++) {

            if(flag) {
                start = s.charAt(i);
                flag = false;
                continue;
            }

            if(s.charAt(i)==start)
                countA++;
            else
                countB++;

            if(countA==countB) {
                flag = true;
                countA = 1;
                countB = 0;
                answer++;
            }
        }

        if(!flag)
            answer++;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
    }
}
