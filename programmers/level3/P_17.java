package com.study.codingtest.programmers.level3;

public class P_17 {
    static boolean isPossible(int[] stones, int k, int mid){

        //연속으로 징검다리 건너뛰는 횟수
        int count = 0;

        for(int stone : stones){

            //징검다리에서 현재 인원수를 뺀 숫자가 0보다 작으면 건너뛰어야함
            if(stone-mid<=0)
                count++;
            else
                count = 0;

            if(count>=k)
                return false;
        }

        return true;
    }

    static int binarySearch(int [] stones, int k, int max){

        int low = 1;
        int high = max;

        while(low<=high){

            int mid = (low+high)/2; //인원수

            if(isPossible(stones, k, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public int solution(int[] stones, int k) {

        int max = 0;
        for(int stone : stones)
            max = Math.max(max, stone);

        return binarySearch(stones, k, max);
    }
}
