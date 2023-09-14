package com.study.codingtest.programmers.level2;

import java.util.Arrays;

public class P_10 {

    public long solution(int n) {
        long answer = 0;
        long [] result = new long [n+1];

        result[1] = 1;

        if(n>=2)
            result[2] = 2;

        for(int i=3; i<=n; i++)
            result[i] = (result[i-2] + result[i-1])%1234567;

        System.out.println(Arrays.toString(result));

        return result[n];
    }
}
