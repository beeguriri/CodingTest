package com.study.codingtest.programmers.level1;

import java.util.*;

public class P_04 {

    //사전으로 만들어보기
    static String [] bab = {"aya", "ye", "woo", "ma"};
    static boolean [] check = new boolean [4];
    static Set<String> set = new HashSet<>();

    static void dfs(int depth, String str) {

        if(depth==4)
            return;

        set.add(str);

        for(int i=0; i<4; i++) {

            if(!check[i]) {
                check[i] = true;
                dfs(depth+1, str+bab[i]);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        dfs(0, "");
//        System.out.println(set);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String l : list)
            System.out.println(l);

    }
}
