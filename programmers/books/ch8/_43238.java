package com.study.codingtest.programmers.books.ch8;

import java.util.Arrays;

public class _43238 {

    static long lowerBinarySearch(long minTime, long maxTime, int[] times, int target) {

        while(minTime<=maxTime){

            long midTime = (minTime + maxTime) / 2;
            long count = 0;

            //평균시간을 각 시간으로 나눈 후 더하면,
            //심사할 수 있는 사람의 수 계산 할 수 있음
            for(int time : times){
                count += midTime / time;
                if(count>=target)
                    break;
            }

            if(count<target)
                minTime = midTime+1;
            else
                maxTime = midTime-1;
        }

        return minTime;
    }

    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long maxTime = (long)times[times.length-1]*n; //대기시간이 제일 긴 경우
        long minTime = 1; //대기시간이 제일 짧은 경우

        return lowerBinarySearch(minTime, maxTime, times, n);
    }
}
