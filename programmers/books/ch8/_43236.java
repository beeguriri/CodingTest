package com.study.codingtest.programmers.books.ch8;

import java.util.Arrays;

public class _43236 {

    static int upperBinarySearch(int start, int end, int distance, int target, int [] rocks) {

        while(start<=end) {

            int mid = (start+end)/2;

            //제거한 돌의 개수가 target보다 작거나 같으면 다시 탐색
            if(getRemoveRocks(mid, distance, rocks)<=target)
                start = mid+1;
            else
                end = mid-1;
        }
        return start-1; //upperBound는 다음으로 나오는 제일 큰수
    }

    static int getRemoveRocks(int mid, int distance, int [] rocks) {

        int prev = 0;
        int count = 0;

        for(int rock : rocks){

            //돌 사이의 간격이 target(mid) 보다 작으면 돌 제거
            if(rock-prev<mid){
                count++;
                continue;
            }

            prev = rock;
        }

        if(distance-prev<mid)
            count++;

        return count;
    }

    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);
        //시작은 1 (거리 최소값이 1이라고 했으므로)
        //종료는 distance
        return upperBinarySearch(1, distance, distance, n, rocks);
    }
}
