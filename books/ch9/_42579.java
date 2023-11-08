package com.study.codingtest.books.ch9;

import java.util.*;

public class _42579 {

    public int[] solution(String[] genres, int[] plays) {

        //장르별로 재생 횟수를 더하는 맵
        //장르별로 int [] : 인덱스, 재생길이 받아서 나중에 정렬!
        Map<String, Integer> countPlay = new HashMap<>();
        Map<String, List<int[]>> info = new HashMap<>();

        for(int i=0; i<genres.length; i++ ){
            countPlay.put(genres[i], countPlay.getOrDefault(genres[i], 0)+plays[i]);

            if(!info.containsKey(genres[i]))
                info.put(genres[i], new ArrayList<>());

            info.get(genres[i]).add(new int [] {i, plays[i]});
        }

        // System.out.println(countPlay);
        // System.out.println(info);

        //장르별로 가장 많이 재생 된 노래를 두개씩 모음
        //장르에 속한 곡이 하나면 하나만 선택
        //속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        //장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        List<String> keys = new ArrayList<>(countPlay.keySet());
        Collections.sort(keys, (o1, o2) -> countPlay.get(o2)-countPlay.get(o1));
        for(String key : keys)
            Collections.sort(info.get(key), (o1, o2) -> o1[1]==o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

        List<Integer> result = new ArrayList<>();
        for(String key : keys){
            if(info.get(key).size()>=2){
                result.add(info.get(key).get(0)[0]);
                result.add(info.get(key).get(1)[0]);
            } else {
                result.add(info.get(key).get(0)[0]);
            }
        }

        // System.out.println(result);

        return result.stream().mapToInt(i->i).toArray();
    }
}
