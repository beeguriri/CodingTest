package com.study.codingtest.books.ch7;

import java.util.Arrays;

public class _42746 {

    public String solution(int[] numbers) {

        String [] temp = new String [numbers.length];
        int idx = 0;
        for(int i : numbers)
            temp[idx++] = String.valueOf(i);

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
