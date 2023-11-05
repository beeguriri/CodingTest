package com.study.codingtest.programmers.books.ch6;

import java.util.*;

public class _42840 {

    public int[] solution(int[] answers) {

        int [] first = {1, 2, 3, 4, 5};
        int [] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int [] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int [] count = new int [3];

        for(int i=0; i<answers.length; i++) {

            if(first[i%first.length]==answers[i])
                count[0]++;
            if(second[i%second.length]==answers[i])
                count[1]++;
            if(third[i%third.length]==answers[i])
                count[2]++;
        }

        int max = -1;
        for(int c : count)
            max = Math.max(max, c);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<count.length; i++)
            if(count[i]==max)
                list.add(i+1);

        return list.stream().mapToInt(i->i).toArray();
    }
}
