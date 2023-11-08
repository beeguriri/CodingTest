package com.study.codingtest.books.ch6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _64064 {

    static Set<String> set = new HashSet<>();

    static boolean isPossible(String result, String banned_id) {

        if(result.length() != banned_id.length())
            return false;

        for(int i=0; i<result.length(); i++){
            if(banned_id.charAt(i)=='*')
                continue;

            if(banned_id.charAt(i)!=result.charAt(i))
                return false;
        }

        return true;
    }

    //dfs로 완전 탐색 (순열만들기)
    static void dfs(int depth, String result, String [] user_id, String [] banned_id, boolean [] check) {

        //종료조건
        if(depth == banned_id.length){

            //문자열로 넣어주면 중복 제거 할 수 있음!!
            // System.out.println(result);
            String [] temp = result.split(" ");
            Arrays.sort(temp);

            StringBuilder sb = new StringBuilder();
            for(String s : temp)
                sb.append(s);

            set.add(sb.toString()) ;

            return;
        }

        for(int i=0; i<user_id.length; i++){
            //이 조건에 못 들어왔을 때
            //배열의 length 는 이미 만족할 수 있으므로...
            //배열로 결과 받기 불가
            if(!check[i] && isPossible(user_id[i], banned_id[depth])){
                check[i] = true;
                dfs(depth+1, result + " " + user_id[i], user_id, banned_id, check);
                check[i] = false;
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, "", user_id, banned_id, new boolean[user_id.length]);
        return set.size();
    }
}
