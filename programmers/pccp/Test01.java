package com.study.codingtest.programmers.pccp;

//[PCCP 모의고사 #1] 외톨이 알파벳

import java.util.*;

public class Test01 {

    static int findStar(String str) {

        int count = 0;

        for(char c : str.toCharArray())
            if(c=='*')
                count++;

        return count;
    }

    public static String solution(String input_string) {
        String answer = "";
        Set<String> set = new HashSet<>();
        for(char c : input_string.toCharArray())
            set.add(String.valueOf(c));
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for(String alpha : list) {

            String dir = "[" + alpha + "]+";
            String temp = input_string;

            temp = temp.replaceAll(dir, "*");

            //별표 갯수 새서 별표가 2개 이상이면 외톨이 알파뱃
            if(findStar(temp)>=2)
                answer += alpha;

        }

        return answer.isEmpty() ? "N" : answer;
    }

    public static void main(String[] args) {

    }
}
