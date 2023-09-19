package com.study.codingtest.programmers.level2;

/*
n진수 게임
 */

public class P_27 {
    //실행시간 줄이려면 .. 스트링빌더 써야할듯
    public String solution(int n, int t, int m, int p) {
        //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
        //전체 구해야 할 문자의 길이는 m*t

        String answer = "";
        StringBuilder sb = new StringBuilder();

        //문자열 만들기
        int number = 0;
        while (sb.length()<=t*m) {
            String temp = Integer.toString(number, n);
            sb.append(temp);
            number++;
        }

        String master = sb.toString().toUpperCase();
        System.out.println(master);

        sb = new StringBuilder();
        //튜브가 말해야할 문자 계산
        for(int i=0; i<t*m; i+=m)
            sb.append(master.charAt(i+p-1));

        // System.out.println(answer);

        return sb.toString();
    }
}
