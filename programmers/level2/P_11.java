package com.study.codingtest.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class P_11 {

    static Set<Integer> set = new HashSet<>();

    static void makeSum(int n, int [] elements) {

        for(int i=0; i<elements.length; i++) {
            int sum = 0;
            for(int j=i; j<i+n; j++)
                sum += elements[j%elements.length];

            set.add(sum);
        }

    }

    public static int solution(int[] elements) {

        for(int i : elements)
            set.add(i);

        for(int i=2; i<=elements.length; i++)
            makeSum(i, elements);

        System.out.println(set);

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {7,9,1,1,4}));
    }
}
