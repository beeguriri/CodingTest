package com.study.codingtest.programmers.level2;

import java.util.*;

/*
택배 배달
 */

public class P_42 {

    public int solution(int[] order) {

        int answer = 0;

        //순서대로 꺼낼 수 있는 최대갯수 찾기
        //main에서는 앞에서 부터 꺼내기 => 큐
        //sub에서는 뒤에서 부터 꺼내기 => 스택
        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();

        for(int i=1; i<=order.length; i++)
            main.offer(i);

        for(int o : order) {
            while(!main.isEmpty() || !sub.isEmpty()) {
                if(!main.isEmpty() && main.peek()==o){
                    main.poll();
                    answer++;
                    break;
                } else if(!sub.isEmpty() && sub.peek()==o){
                    sub.pop();
                    answer++;
                    break;
                } else {
                    if(!main.isEmpty())
                        sub.push(main.poll());
                    else
                        return answer;
                }
            }
        }
        return answer;
    }
}
