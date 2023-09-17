package com.study.codingtest.baekjoon.implement;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++)
            queue.offer(i);

        //1, 2, 3, 4, 5, 6, 7
        //2, 3, 4, 5, ,6 7, 1
        //(3), 4, 5, 6, 7, 1, 2
        //4, 5, 6, 7, 1, 2
        //5, 6, 7, 1, 2, 4
        // (6), 7, 1, 2, 4, 5
        while(!queue.isEmpty()) {
            for(int i=0; i<k-1; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }

        String answer = sb.toString();
        answer = answer.substring(0, answer.length()-2);
        answer += ">";

        System.out.println(answer);
    }
}
