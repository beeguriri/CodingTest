package com.study.codingtest.programmers.level2;

/*
멀쩡한 사각형
 */
public class P_68 {

    static long gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b, a%b);
    }

    public long solution(int w, int h) {

        long answer = (long)w*h;

        if(w==h)
            return answer-w;

        //최대공약수 구해서 w*h - [w/gcd*h/gcd - (w/gcd-1)*(h/gcd-1)]*gcd
        long len = gcd(w, h);
        long lenW = w/len;
        long lenH = h/len;

        answer -= (lenW*lenH - (lenW-1)*(lenH-1))*len;
        return answer;
    }
}
