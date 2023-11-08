package com.study.codingtest.programmers.books.ch11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _67258 {

    public int[] solution(String[] gems) {

        int [] answer = new int [2];
        int start = 0;
        int length = Integer.MAX_VALUE; //start와 end의 거리 확인용

        //보석의 갯수를 구하고
        Set<String> set = new HashSet<>();
        for(String gem : gems)
            set.add(gem);
        int total = set.size();

        //보석을 맵에 하나씩 넣어가며 확인
        Map<String, Integer> map = new HashMap<>();
        for(int end=0; end<gems.length; end++){

            map.put(gems[end], map.getOrDefault(gems[end], 0)+1);

            //배열의 첫번째 원소부터 확인해서
            //2개 이상이면 맵에서 제거하고 start 증가시키기
            while(map.get(gems[start])>1){
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }

            System.out.printf("end:%d, start:%d\n", end, start);

            //map의 크기(키의 갯수)가 전체 보석종류와 같으면,
            //거리 확인 해보고 갱신
            if(map.size()==total && length>end-start){
                length = end-start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }

        return answer;
    }
}
