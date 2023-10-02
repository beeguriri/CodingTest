package com.study.codingtest.programmers.level2;

import java.util.*;
/*
혼자 놀기 달인
[8,6,3,7,2,5,1,4]
i=0 : 1번상자 열면 => 8(i=7)
i=7 : 8번상자 열면 => 4(i=3)
i=3 : 4번상자 열면 => 7(i=6)
i=6 : 7번상자 열면 => 1(i=0)
===> i=0은 이미 열었으므로 count = 4
i=1 : 2번상자 열면 => 6(i=5)
i=5 : 6번상자 열면 => 5(i=4)
i=4 : 5번상자 열면 => 2(i=1)
===> i=1은 이미 열었으므로 count = 3
i=2 : 3번상자 열면 => 3(i=2)
===> i=2은 이미 열었으므로 count = 1
=============
1번상자와 2번상자 수 곱하면 12
 */
public class P_75 {
    
    static boolean [] check;
    static List<Integer> list = new ArrayList<>();

    static void dfs(int [] cards, int index, int count){

        //종료조건
        if(check[index]){
            list.add(count);
            return;
        }

        check[index] = true;
        dfs(cards, cards[index]-1, count+1);
    }

    public int solution(int[] cards) {
        int answer = 0;
        check = new boolean[cards.length];

        for(int i=0; i<cards.length; i++){
            if(!check[i])
                dfs(cards, i, 0);
        }

        Collections.sort(list, Collections.reverseOrder());

        return list.size()==1 ? 0 : list.get(0)*list.get(1);
    }
}
