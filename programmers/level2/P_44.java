package com.study.codingtest.programmers.level2;

import java.util.*;
/*
가장 큰 수
- 정렬
 */
public class P_44 {

    public String solution(int[] numbers) {

        String [] temp = new String [numbers.length];
        for(int i=0; i<numbers.length; i++)
            temp[i] = String.valueOf(numbers[i]);

        // Arrays.sort(temp);
        Arrays.sort(temp, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        // System.out.println(Arrays.toString(temp));

        if(temp[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : temp)
            sb.append(s);

        return sb.toString();
    }
}
