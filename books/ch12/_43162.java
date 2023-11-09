package com.study.codingtest.books.ch12;

import java.util.HashSet;
import java.util.Set;

public class _43162 {

    //서로소로 풀어야하나..?
    static int [] parents;

    static int findParent(int x){
        if(x==parents[x])
            return x;

        return parents[x] = findParent(parents[x]);

    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<b)
            parents[b] = a;
        else
            parents[a] = b;
    }

    public int solution(int n, int[][] computers) {

        Set<Integer> set = new HashSet<>();

        parents = new int [n];

        for(int i=0; i<n; i++)
            parents[i] = i;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;


                if(computers[i][j]!=0 && findParent(i)!=findParent(j))
                    unionParent(i, j);
            }
        }

        // System.out.println(Arrays.toString(parents));

        //부모노드를 한번 더 찾아서 갱신
        for(int i : parents)
            set.add(parents[i]);

        return set.size();
    }
}
