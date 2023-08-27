package com.study.codingtest.baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14003 {

    static int [] numbers;
    static int [] result;

    static int binarySearch(int low, int high, int target) {

        while(low<=high){
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
            if(result[idx]<numbers[i])
                result[++idx] = numbers[i];
            else {
                int targetIdx = binarySearch(0, idx, numbers[i]);
                result[targetIdx] = numbers[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        sb.append(idx+1).append("\n");

        for(int i=0; i<n; i++) {
            if (result[i] == 0)
                break;
            else
                queue.offer(result[i]);
        }

        while(!queue.isEmpty())
            sb.append(queue.poll()).append(" ");

        System.out.println(sb);
    }

    //input:
    //16
    //-60 -41 -100 8 -8 -52 -62 -61 -76 -52 -52 14 -11 -2 -54 46
    //
    //output:
    //7
    //-60 -41 -61 -52 -11 -2 46
    //
    //answer:
    //7
    //-100 -62 -61 -52 -11 -2 46
}
