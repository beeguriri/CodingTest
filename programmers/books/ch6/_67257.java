package com.study.codingtest.programmers.books.ch6;

import java.util.*;

public class _67257 {

    static String [][] operations = {
            {"+","-","*"}, {"+","*","-"},
            {"-","+","*"}, {"-","*","+"},
            {"*","+","-"}, {"*","-","+"}
    };


    static long calcExpression(String x, String y, String op) {

        long xNum = Long.parseLong(x);
        long yNum = Long.parseLong(y);

        if(op.equals("+"))
            return xNum+yNum;
        else if(op.equals("-"))
            return xNum-yNum;
        else
            return xNum*yNum;
    }

    public long solution(String expression) {

        long max = -1;

        //수식을 먼저 분해 하고
        List<String> list = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                list.add(expression.substring(idx, i)); //숫자 넣고
                list.add(expression.substring(i, i+1)); //연산자 넣고
                idx = i+1;
            }
        }
        //남은 숫자 넣기
        list.add(expression.substring(idx));


        //연산자 별 우선순위로 값 계산해서 max 갱신
        for(String [] operation : operations) {
            List<String> temp = new ArrayList<>(list);
            for(String op : operation){
                for(int i=0; i<temp.size(); i++) {
                    if(temp.get(i).equals(op)){
                        long result = calcExpression(temp.get(i-1), temp.get(i+1), temp.get(i));
                        temp.remove(i+1);
                        temp.remove(i);
                        temp.add(i, String.valueOf(result));
                        temp.remove(i-1);
                        i = i-1;
                    }
                }
            }
            max = Math.max(max, Math.abs(Long.parseLong(temp.get(0))));
        }

        return max;
    }
}
