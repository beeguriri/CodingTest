package com.study.codingtest.pccp1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no1 {

    static int countStar(String str){
        int count = 0;
        for(char c : str.toCharArray()){
            if(c=='*')
                count++;
        }
        return count;
    }

    public String solution(String input_string) {

        //우선 어떤 알파벳이 있는지 확인 하고
        //그 알파벳 순으로 외톨이인지 확인
        //알파벳 뭉치를 특수기호로 치환 한 후
        //특수기호가 2개 이상이면 외톨이

        // Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for(char c : input_string.toCharArray())
            if(!list.contains(c))
                list.add(c);


        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(char c : list) {
            String reg = "[" + String.valueOf(c) + "]+";
            String temp = input_string;

            temp = temp.replaceAll(reg, "*");
            if(countStar(temp)>=2)
                sb.append(c);
        }

        return sb.toString().isEmpty() ? "N" : sb.toString();
    }
}
