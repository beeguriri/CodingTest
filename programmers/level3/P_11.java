package com.study.codingtest.programmers.level3;

import java.util.*;

public class P_11 {

    public static int[] solution(String[] genres, int[] plays) {

        //장르별로 카운트 해서 map 으로 저장
        //장르 안에서 순번과 재생 횟수 저장 하고 정렬
        Map<String, Integer> map = new HashMap<>();
        Map<String, ArrayList<int []>> play = new HashMap<>();

        for(int i=0; i<genres.length; i++)
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);

        for(String s : map.keySet())
            play.put(s, new ArrayList<>());

        for(int i=0; i<genres.length; i++) {
            ArrayList<int []> list = play.get(genres[i]);
            list.add(new int [] {i, plays[i]});
            play.put(genres[i], list);
        }

        //map의 values 정렬
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));

        //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        //장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            ArrayList<int[]> list = new ArrayList<>(play.get(key));
            list.sort((o1, o2) -> o2[1] == o1[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

            result.add(list.get(0)[0]);
            if(list.size()>=2)
                result.add(list.get(1)[0]);

        }

        int [] answer = new int [result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String [] {"classic", "pop", "classic", "classic", "pop"}, new int [] {500, 600, 150, 800, 2500})));
    }
}
