package com.study.codingtest.books.ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _131704 {

    public int solution(int[] order) {
        int answer = 0;

        //보조 : 맨앞의 상자만 뺄 수 있음 (마지막에 보관한 상자부터) => 스택
        //메인 : 넣은 순서대로 앞에서 꺼낼거라 => 큐

        //i번째 상자가 들어왔을때 메인의 순서와 같으면 메인에서 poll
        //아니면 보조에 있으면 보조에서 pop, 없으면 push
        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();

        for(int i=1; i<= order.length; i++)
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
