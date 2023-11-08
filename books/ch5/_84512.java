package com.study.codingtest.books.ch5;

import java.util.*;

public class _84512 {

    static String [] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    //중복을 허용해서 만듦
    static void dfs(String word) {

        //종료조건
        if(word.length()>5)
            return;

        for(String s : vowels){
            if(!list.contains(word))
                list.add(word);
            dfs(word+s);
        }

    }

    public int solution(String word) {

        dfs("");

        Collections.sort(list);

        return list.indexOf(word);
    }
}
