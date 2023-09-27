package com.study.codingtest.programmers.level2;

import java.util.*;

/*
메뉴 리뉴얼
*/

public class P_52 {

    //각 메뉴별 횟수 저장용 맵
    static Map<String, Integer> map = new HashMap<>();

    //각 메뉴 조합 만들기
    static void comb(char [] input, char [] output, int depth, int next, int n, int r) {

        //종료조건
        if(depth==r) {
            //맵에 추가
            String key = String.valueOf(output);
            map.put(key, map.getOrDefault(key, 0)+1);
            return;
        }

        for(int i=next; i<input.length; i++) {
            output[depth] = input[i];
            comb(input, output, depth+1, i+1, n, r);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        //메뉴를 알파벳 순으로 정렬
        for(int i=0; i<orders.length; i++){
            char [] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
            // System.out.println(orders[i]);
        }

        //course에 따라서 메뉴 조합 만들기
        for(int c : course) {
            for(String order : orders) {
                comb(order.toCharArray(), new char [c], 0, 0, order.length(), c);
            }

            //해당 코스의 숫자 확인하여 결과List에 담기
            List<String> temp = new ArrayList<>(map.keySet());
            Collections.sort(temp,
                    (o1, o2) -> map.get(o2)-map.get(o1));

            if(!temp.isEmpty()) {
                int max = map.get(temp.get(0));

                if(max<2)
                    break;

                for(String t : temp){
                    if(map.get(t)==max)
                        result.add(t);
                }
            }

            map.clear();
        }

        //result 오름차순 정렬
        Collections.sort(result);
        String[] answer = new String [result.size()];
        for(int i=0; i<result.size(); i++)
            answer[i] = result.get(i);

        return answer;
    }
}
