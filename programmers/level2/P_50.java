package com.study.codingtest.programmers.level2;

import java.util.*;

/*
연속된 부분 수열의 합
 */
public class P_50 {

    public int[] solution(int[] sequence, int k) {

        //list에 부분수열의 합을 모두 넣고
        //size로 정렬 -> 인덱스로 정렬?
        List<int []> list = new ArrayList<>();
        long sum = sequence[0];
        int start = 0;
        int last = 0;

        while(start <= last){

            if(sum==k){
                list.add(new int [] {start, last});
                sum -= sequence[start++];

                if(last+1<sequence.length)
                    sum += sequence[++last];
                else if(last+1>=sequence.length)
                    break;
            }

            else if(sum>k){
                sum -= sequence[start++];
            } else {
                if(last+1<sequence.length)
                    sum += sequence[++last];
                else if(last+1>=sequence.length)
                    break;
            }
        }

        Collections.sort(list,
                (o1, o2) ->
                        (o1[1]-o1[0]) == (o2[1]-o2[0]) ?
                                o1[0] - o2[0] : (o1[1]-o1[0]) - (o2[1]-o2[0]));

        return list.get(0);
    }
}
