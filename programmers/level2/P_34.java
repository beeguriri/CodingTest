package com.study.codingtest.programmers.level2;

import java.util.*;
/*
오픈채팅방
 */
public class P_34 {

    public String[] solution(String[] record) {
        String[] answer = {};

        //map에 uid에 따른 닉네임 저장
        Map<String, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String s : record) {
            String mode = s.split(" ")[0];
            String uid = s.split(" ")[1];
            if(mode.equals("Enter"))
                map.put(uid, s.split(" ")[2]);
            else if(mode.equals("Change"))
                map.put(uid, s.split(" ")[2]);
        }
        // System.out.println(map);

        //result에 채팅 메시지 작성
        for(String s : record) {
            String mode = s.split(" ")[0];
            String uid = s.split(" ")[1];
            if(mode.equals("Enter"))
                result.add(map.get(uid)+"님이 들어왔습니다.");
            else if(mode.equals("Leave"))
                result.add(map.get(uid)+"님이 나갔습니다.");
        }

        // System.out.println(result);

        return result.toArray(String[]::new);
    }
}
