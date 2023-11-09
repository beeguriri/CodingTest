package com.study.codingtest.books.ch7;

import java.util.*;

public class _68644 {

    static Set<Integer> set = new HashSet<>();

    static void dfs(int depth, int sum, int [] numbers, boolean [] check) {

        if(depth==2){
            set.add(sum);
            return;
        }

        for(int i=0; i<numbers.length; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(depth+1, sum+numbers[i], numbers, check);
                check[i] = false;
            }
        }
    }

    public int[] solution(int[] numbers) {

        dfs(0, 0, numbers, new boolean [numbers.length]);

        int[] answer = new int [set.size()];
        int idx = 0;
        for(int i : set)
            answer[idx++] = i;

        Arrays.sort(answer);

        return answer;
    }
}
