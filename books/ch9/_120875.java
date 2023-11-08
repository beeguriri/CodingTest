package com.study.codingtest.books.ch9;

public class _120875 {

    //기울기 : y2-y1/x2-x1, 기울기가 같으면 평행!

    static double calSlope(int [] dot1, int [] dot2) {

        double x1 = dot1[0];
        double y1 = dot1[1];

        double x2 = dot2[0];
        double y2 = dot2[1];

        return (y2-y1)/(x2-x1);

    }

    public int solution(int[][] dots) {

        if(calSlope(dots[0], dots[1])==calSlope(dots[2], dots[3]))
            return 1;

        if(calSlope(dots[0], dots[2])==calSlope(dots[1], dots[3]))
            return 1;

        if(calSlope(dots[0], dots[3])==calSlope(dots[1], dots[2]))
            return 1;

        return 0;
    }
}
