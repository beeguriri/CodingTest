package com.study.codingtest.programmers.books.ch11;

import java.util.Arrays;
import java.util.Stack;

public class _154539 {
    public int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int [numbers.length];
        Arrays.fill(answer, -1);

        //다음 큰수가 나올때 까지 인덱스를 담자!
        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];

            stack.push(i);
        }

        return answer;
    }

}
