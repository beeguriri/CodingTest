package com.study.codingtest.books.ch12;

import java.util.Stack;

public class _67256 {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        //키패드 위치를 나타내는 배열
        int [][] keys = {{0,0}, {0,1}, {0,2},
                {1,0}, {1,1}, {1,2},
                {2,0}, {2,1}, {2,2},
                {3,0}, {3,1}, {3,2}};

        //마지막 키를 누른 위치를 확인할거라 Stack 사용함
        Stack<int []> left = new Stack<>();
        Stack<int []> right = new Stack<>();

        //맨 처음 왼손 엄지는 *, 오른손 엄지는 #
        left.push(keys[9]);
        right.push(keys[11]);

        for(int n : numbers) {

            if(n==1 || n==4 || n==7) {
                left.push(keys[n-1]);
                sb.append("L");
            } else if(n==3 || n==6 || n==9) {
                right.push(keys[n-1]);
                sb.append("R");
            } else {

                if(n==0) n=11;
                //가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는
                //두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
                int distL = Math.abs(keys[n-1][0]-left.peek()[0]) + Math.abs(keys[n-1][1] - left.peek()[1]);
                int distR = Math.abs(keys[n-1][0]-right.peek()[0]) + Math.abs(keys[n-1][1] - right.peek()[1]);

                // System.out.printf("distL: %d, distR: %d\n", distL, distR);

                if(distL<distR){
                    left.push(keys[n-1]);
                    sb.append("L");
                } else if (distL>distR) {
                    right.push(keys[n-1]);
                    sb.append("R");
                } else {
                    //만약 두 엄지손가락의 거리가 같다면,
                    //오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
                    if(hand.equals("right")){
                        right.push(keys[n-1]);
                        sb.append("R");
                    } else {
                        left.push(keys[n-1]);
                        sb.append("L");
                    }
                }
            }

        }

        return sb.toString();
    }
}
