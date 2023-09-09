package com.study.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_10 {

    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();

        //char 배열을 만들고, skip에 있는거는 빼자!
        List<String> list = new ArrayList<>();
        for(int i=97; i<=122; i++)
            list.add(String.valueOf((char)i));

        System.out.println((int)'a'); //97
        System.out.println((int)'z'); //122

        list.removeAll(Arrays.asList(skip.split("")));
        System.out.println(list);

        //list index로 계산하기
        for(int i=0; i<s.length(); i++) {

            int idx = (index + list.indexOf(s.substring(i, i+1))) % list.size();
            sb.append(list.get(idx));

        }


        return sb.toString();
    }
}
