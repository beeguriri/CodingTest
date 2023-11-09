package com.study.codingtest.books.ch11;

import java.util.PriorityQueue;

public class _42628 {

    public int[] solution(String[] operations) {

        //우선순위큐 기본이 최소값 우선
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for(String op : operations){
            if(op.startsWith("I")){
                String [] temp = op.split(" ");
                int number = Integer.parseInt(temp[1]);
                maxQ.offer(number);
                minQ.offer(number);
            } else if(op.equals("D 1")){
                if(!maxQ.isEmpty() && !minQ.isEmpty()){
                    minQ.remove(maxQ.poll());
                }
            } else {
                if(!maxQ.isEmpty() && !minQ.isEmpty()) {
                    maxQ.remove(minQ.poll());
                }
            }
        }

        // System.out.println(maxQ);
        // System.out.println(minQ);

        if(maxQ.isEmpty() && minQ.isEmpty())
            return new int [] {0, 0};

        return new int [] {maxQ.poll(), minQ.poll()};
    }
}
