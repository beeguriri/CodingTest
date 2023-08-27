package com.study.codingtest.baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12738 {

    /*
    가장 긴 증가하는 부분 수열 3
    숫자가 커서 2중for문 도는 dp로는 시간초과
     */

    static int [] numbers;
    static int [] result;

    static int binarySearch(int low, int high, int target) {

        while(low<=high) {

            int mid = (low+high)/2;

            if(result[mid]<target)
                low = mid+1;
            else
                high = mid-1;
        }

        return low;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int [n];
        result = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        result[0] = numbers[0];
        int idx = 0;
        for(int i=1; i<n; i++) {
            if(numbers[i]>result[idx])
                result[++idx] = numbers[i];
            else {
                //result 배열의 앞에 어딘가 넣어줌
                int targetIdx = binarySearch(0, idx, numbers[i]);
                result[targetIdx] = numbers[i];
            }
        }

        System.out.println(idx+1);

    }
}
