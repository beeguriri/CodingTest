package com.study.codingtest.programmers.level2;

import java.util.*;

/*
압축
 */

public class P_26 {

    public int[] solution(String msg) {

        //길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        List<String> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // System.out.println((int)'A');
        for(int i=0; i<26; i++)
            list.add(String.valueOf((char)(65+i)));

        for(int i=0; i<msg.length(); i++) {

            int cur = 1;

            //최장길이 단어가 리스트에 없을때 까지 찾기
            while(i+cur<=msg.length()
                    && list.contains(msg.substring(i, i+cur))) {
                cur++;
            }

            //문자열 마지막 처리
            if(i+cur>msg.length()) {
                result.add(list.indexOf(msg.substring(i))+1);
                break;
            }

            //w에 해당하는 색인번호 출력
            result.add(list.indexOf(msg.substring(i, i+cur-1))+1);

            //w+c에 해당하는 단어 사전에 등록
            list.add(msg.substring(i, i+cur));

            //i값 변경
            i = i+cur-2;

        }

        // System.out.println(list);
        // System.out.println(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}
