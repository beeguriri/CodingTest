package com.study.codingtest.programmers.books.ch8;

import java.util.*;

public class _72412 {

    static Map<String, List<Integer>> map = new HashMap<>(); //query, 숫자목록

    static void dfs(int depth, String[] param, String[] info){

        if(depth==4){

            String query = String.join("", param);

            if(!map.containsKey(query))
                map.put(query, new ArrayList<>());

            List<Integer> temp = map.get(query);
            temp.add(Integer.parseInt(info[4]));
            map.put(query, temp);

            return;
        }

        param[depth] = info[depth];
        dfs(depth+1, param, info);
        param[depth] = "-";
        dfs(depth+1, param, info);

    }

    static int binarySearch(List<Integer> score, int target){

        int start = 0;
        int end = score.size()-1;

        while(start<=end) {

            int mid = (start+end)/2;
            if(score.get(mid)<target)
                start = mid+1;
            else
                end = mid-1;
        }

        return start;

    }

    public int[] solution(String[] info, String[] query) {

        int[] answer = new int [query.length];

        //모든 쿼리 만들어놓고 정렬
        for(String s : info)
            dfs(0, new String [4], s.split(" "));

        //왜 여기가 시간초과가 안나는지 몰게씀
        for(String key : map.keySet())
            Collections.sort(map.get(key));

        //탐색!
        int idx=0;
        for(String q : query) {

            //query 한개를 우선 map의 query에 맞게 다시 만들기
            String [] temp = q.split(" and | ");
            String key = temp[0]+temp[1]+temp[2]+temp[3];
            int target = Integer.parseInt(temp[4]);

            //info 정보로만 쿼리(key)를 만들기 때문에
            //실제 입력된 쿼리가 info로 만든 key가 없을 수 있음!
            if(!map.containsKey(key))
                answer[idx++] = 0;
            else{
                List<Integer> score = map.get(key);

                //왜 여기가 시간초과가 나는지 몰게씀
                // Collections.sort(score);

                answer[idx++] = score.size() - binarySearch(score, target);
            }

        }

        return answer;
    }
}
