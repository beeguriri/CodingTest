package com.study.codingtest.programmers.level2;

import java.util.*;
/*
주차 요금 계산
 */

public class P_28 {


    static int calcTime(String in, String out) {

        int hour = (Integer.parseInt(out.split(":")[0]) - Integer.parseInt(in.split(":")[0]))*60;
        int min = Integer.parseInt(out.split(":")[1]) - Integer.parseInt(in.split(":")[1]);

        return hour + min;

    }

    public int[] solution(int[] fees, String[] records) {

        //입차내역 : 차량번호, 입차시간으로 관리
        //출차내역 : 차량번호, 누적시간으로 관리 (출차-입차)
        Map<String, String> in = new HashMap<>();
        Map<String, Integer> out = new HashMap<>();

        for(String record : records) {
            String time = record.split(" ")[0];
            String number = record.split(" ")[1];
            String inout = record.split(" ")[2];

            if(inout.equals("IN"))
                in.put(number, time);
            else {

                int sumTime = calcTime(in.get(number), time);
                out.put(number, out.getOrDefault(number, 0) + sumTime);
                in.remove(number);
            }
        }

        //출차 되지않은 차량 계산해주기
        for(String key : in.keySet()) {
            int sumTime = calcTime(in.get(key), "23:59");
            out.put(key, out.getOrDefault(key, 0) + sumTime);
        }

        // 차량번호가 작은 자동차로 정렬 후 주차요금 계산
        List<String> list = new ArrayList<>(out.keySet());
        List<Integer> result = new ArrayList<>();

        Collections.sort(list);

        //int [] fees
        //기본시간, 기본요금, 단위시간, 단위요금
        for(String key : list) {

            int time = out.get(key);
            if(time>fees[0]){
                int sum = fees[1];
                sum += (int)(Math.ceil((double)(time-fees[0])/fees[2])) * fees[3];
                result.add(sum);

            } else
                result.add(fees[1]);
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
