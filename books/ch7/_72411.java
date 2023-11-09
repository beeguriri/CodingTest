package com.study.codingtest.books.ch7;

import java.util.*;

public class _72411 {

    static Map<String, Integer> map = new HashMap<>(); //메뉴, 횟수

    //순열 아니고 조합임!
    static void dfs(int depth, int start, String menu, char [] order, int target) {

        if(depth==target){
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for(int i=start; i<order.length; i++)
            dfs(depth+1, i+1, menu+String.valueOf(order[i]), order, target);

    }

    public String[] solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        //orders 배열의 원소를 일단 정렬해서 넣어두고,
        for(int i=0; i<orders.length; i++){
            char [] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        //메뉴의 조합을 만들자!
        for(int target : course){

            for(String order : orders)
                dfs(0, 0, "", order.toCharArray(), target);

            //조합 만든 거에서 정렬 후 확인
            List<String> temp = new ArrayList<>(map.keySet());
            if(!temp.isEmpty()) {

                Collections.sort(temp, (o1, o2) -> map.get(o2) - map.get(o1));

                int max = map.get(temp.get(0));

                if(max<2)
                    break;

                for(String menu : temp){
                    if(map.get(menu)<max)
                        break;

                    if(map.get(menu)==max)
                        result.add(menu);
                }
            }
            map.clear();
        }

        Collections.sort(result);

        String [] answer = new String [result.size()];
        int idx = 0;
        for(String s: result)
            answer[idx++] = s;

        return answer;
    }
}
