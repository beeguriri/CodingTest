package com.study.codingtest.programmers.level2;

/*
124 나라의 숫자
 */

public class P_51 {

    public String solution(int n) {

        //1 %3 = 1 / 1/3 = 0
        //2 %3 = 2  / 2/3 = 0
        //3 %3 = 0 => 4 / 3 / (3+1) = 0
        //4 % 3 = "1" / (4-1)/3=1 / 1%3 = "1"
        //5 % 3 = "2" / (5-2)/3=1 / 1%3 = "1"
        //6 % 3 = "0" => 4 / (6-3)/3 = 1 / 1%3 = "1"
        //7 % 3 = "1" / (7-1)/3 = 2 / 2%3 = "2"

        StringBuilder sb = new StringBuilder();

        while(n>0) {
            if(n%3==0){
                sb.insert(0, "4");
                n = (n-3)/3;
            } else {
                sb.insert(0, n%3);
                n = (n-(n%3))/3;
            }
        }

        return sb.toString();
    }
}
