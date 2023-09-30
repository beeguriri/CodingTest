package com.study.codingtest.programmers.level2;

import java.util.*;

/*
시소 짝궁
 */
public class P_64 {

    static int [][] ratio = {{2, 2}, {3, 2}, {4, 2}, {4, 3}};

    //중복값의 시작
    static int lowerBound(int [] weights, int left, int right, int target) {
        while(left <= right){
            int mid = (left+right)/2;
            if(weights[mid]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    //중복값의 마지막 다음값
    static int upperBound(int [] weights, int left, int right, int target) {
        while(left <= right){
            int mid = (left+right)/2;
            if(weights[mid]<=target)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }

    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);

        for(int [] r : ratio){
            for(int i=0; i<weights.length-1; i++){
                if(weights[i]*r[0]%r[1]!=0)
                    continue;

                int target = weights[i]*r[0]/r[1];

                //target이 weights 배열에 있는지 찾기
                int maxIdx = upperBound(weights, i+1, weights.length-1, target);
                int minIdx = lowerBound(weights, i+1, maxIdx-1, target); //값 못찾으면 maxIdx 반환

                answer += (maxIdx - minIdx);
            }
        }

        return answer;
    }
}
