package com.study.codingtest.programmers.level2;

import java.util.*;
/*
테이블 해시 함수
 */

public class P_69 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되,
        //만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
        Arrays.sort(data,
                (o1,  o2) -> o1[col-1] == o2[col-1] ? o2[0] - o1[0] : o1[col-1] - o2[col-1]);

        //정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
        List<Integer> list = new ArrayList<>();
        for(int i=row_begin; i<=row_end; i++){
            int sum = 0;
            for(int j=0; j<data[0].length; j++)
                sum += (data[i-1][j] % i);

            list.add(sum);
        }

        //row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
        for(int i : list)
            answer ^= i;

        return answer;
    }
}
