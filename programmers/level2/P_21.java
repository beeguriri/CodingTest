package com.study.codingtest.programmers.level2;

import java.util.*;

/*
뉴스 클러스터링
 */
public class P_21 {

    static boolean isPossible(String str) {

        str = str.replaceAll("[^a-z]", "");

        return str.length() == 2;

    }

    public int solution(String str1, String str2) {

        //전처리
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //다중집합 만들기
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++) {
            String temp = str1.substring(i, i+2);
            if(isPossible(temp))
                list1.add(temp);
        }

        for(int i=0; i<str2.length()-1; i++) {
            String temp = str2.substring(i, i+2);
            if(isPossible(temp))
                list2.add(temp);
        }

        // System.out.println(list1);
        // System.out.println(list2);

        //합집합, 교집합 만들기
        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>(list1);

        for(String s : list1){
            if(list2.remove(s))
                inter.add(s);
        }

        if(!list2.isEmpty())
            union.addAll(list2);

        // System.out.println(union);
        // System.out.println(inter);

        return union.isEmpty() && inter.isEmpty() ? 65536 : (int)((double)inter.size()/union.size()*65536);
    }
}
