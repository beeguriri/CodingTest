package com.study.codingtest.programmers.books.ch4;

public class _70129 {

    static int countZero(String s) {
        int count = 0;
        for(char c : s.toCharArray())
            if(c=='0')
                count++;

        return count;
    }

    public int[] solution(String s) {

        int zero = 0;
        int count = 0;
        while(!s.equals("1")) {
            zero += countZero(s);
            s = s.replaceAll("[0]+", "");
            s = Integer.toString(s.length(),2);
            count++;
        }

        return new int [] {count, zero};
    }
}
