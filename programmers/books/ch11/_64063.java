package com.study.codingtest.programmers.books.ch11;

import java.util.HashMap;
import java.util.Map;

public class _64063 {

    //방의 갯수가 10e12 개라서... 서로소로 안품

    //방번호 : 다음에 배정할 수 있는 방번호
    static Map<Long, Long> map = new HashMap<>();

    static long findEmptyRoom(long room){

        if(!map.containsKey(room)){
            map.put(room, room+1);
            return room;
        }

        //키가 이미 존재하면, 맵의 다른 키도 확인 해야함
        long nextRoom = map.get(room);
        long emptyRoom = findEmptyRoom(nextRoom); //재귀로 계속 호출
        map.put(room, emptyRoom); //다음 배정가능 한 방 번호 넣어주기

        return emptyRoom;

    }


    public long[] solution(long k, long[] room_number) {

        long[] answer = new long [room_number.length];

        int idx = 0;
        for(long room : room_number)
            answer[idx++] = findEmptyRoom(room);

        return answer;
    }
}
