package com.study.codingtest.programmers.level2;

import java.util.*;

public class P_18 {
    public int[] solution(String s) {

        //"},"단위로 잘라서 총 갯수 확인
        String [] temp = s.split("},");
        int[] answer = new int [temp.length];

        // "특수문자 제거 후 List에 담아서 size로 정렬"
        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<temp.length; i++) {

            ArrayList<Integer> li = new ArrayList<>();

            temp[i] = temp[i].replaceAll("[{]+", "");
            temp[i] = temp[i].replaceAll("[}]+", "");

            for(String str : temp[i].split(","))
                li.add(Integer.parseInt(str));

            list.add(li);
        }

        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());

        // size 순서대로 결과 담기
        List<Integer> result = new ArrayList<>();
        for(ArrayList<Integer> li : list) {
            for(int i=0; i<li.size(); i++){
                if(!result.contains(li.get(i)))
                    result.add(li.get(i));
            }
        }

        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);
        // System.out.println(result);

        return answer;
    }
}
