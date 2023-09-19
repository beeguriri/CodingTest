package com.study.codingtest.programmers.level2;

import java.util.*;
/*
모음 사전
 */

public class P_31 {

    static List<String> dict = new ArrayList<>();
    static String [] vo = {"A", "E", "I", "O", "U"};

    static void dfs(String s1) {

        //dfs 종료조건
        if(s1.length()>5)
            return;

        dict.add(s1);

        //중복을 허용하므로 check배열 안만들었음
        for(String s : vo)
            dfs(s1+s);

    }

    public int solution(String word) {
        int answer = 0;
        dfs("");

        Collections.sort(dict);
        // System.out.println(dict);

        return dict.indexOf(word);
    }
}
