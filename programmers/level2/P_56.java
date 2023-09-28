package com.study.codingtest.programmers.level2;

import java.util.*;

/*
수식 최대화
 */

public class P_56 {
    static String [][] operator = {{"+", "-", "*"}, {"+", "*", "-"},
            {"-", "+", "*"}, {"-", "*", "+"},
            {"*", "+", "-"}, {"*", "-", "+"}};

    static long calc(long x, long y, String op) {
        if(op.equals("+"))
            return x+y;

        else if(op.equals("-"))
            return x-y;

        else
            return x*y;
    }

    public long solution(String expression) {
        long answer = 0;

        //수식 분리해서 넣어두기
        List<String> exp = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                exp.add(expression.substring(idx, i));
                exp.add(expression.substring(i, i+1));
                idx = i+1;
            }
        }
        exp.add(expression.substring(idx));

        //오퍼레이터 우선순위로 다 돌기
        for(String [] op : operator) {

            ArrayList<String> temp = new ArrayList<>(exp);

            for(int i=0; i<3; i++) {
                for(int j=0; j<temp.size(); j++) {
                    if(op[i].equals(temp.get(j))) {
                        long result = calc(Long.parseLong(temp.get(j-1)),
                                Long.parseLong(temp.get(j+1)), temp.get(j));
                        temp.remove(j+1);
                        temp.remove(j);
                        temp.add(j, String.valueOf(result));
                        temp.remove(j-1);
                        j = j-1;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(temp.get(0))));
        }

        // System.out.println(exp);

        return answer;
    }
}
