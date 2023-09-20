package com.study.codingtest.programmers.level2;

import java.util.*;

/*
뒤에 있는 큰 수 찾기
*/
public class P_35 {

    public int[] solution(int[] numbers) {

        int[] answer = new int [numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>(); //index를 스택에 넣어줌

        for(int i=0; i<numbers.length; i++) {

            //stack에 넣어둔 인덱스의 값보다 현재 값이 크면
            //stack 인덱스보다 큰 값은 현재값
            while(!stack.isEmpty() && numbers[i]>numbers[stack.peek()])
                answer[stack.pop()] = numbers[i];

            stack.push(i);

        }

        //for문 두번 돌면...
        //시간초과가 나겠지 그래
        // for(int i=0; i<numbers.length-1; i++) {
        //     for(int j=i+1; j<numbers.length; j++) {
        //         if(numbers[i]<numbers[j]) {
        //             answer[i] = numbers[j];
        //             break;
        //         }
        //     }
        // }

        return answer;
    }
}
