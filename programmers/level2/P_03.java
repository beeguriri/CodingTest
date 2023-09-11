package com.study.codingtest.programmers.level2;

public class P_03 {

    /*
    다음 큰 숫자
     */
    
    static int countOne(int num) {
        String s = Integer.toString(num, 2);
        int count = 0;
        for(char c : s.toCharArray())
            if(c=='1')
                count++;

        return count;
    }

    public int solution(int n) {

        int count = countOne(n);

        while(true)
            if(countOne(++n)==count)
                return n;

    }

    public static void main(String[] args) {

    }
}
