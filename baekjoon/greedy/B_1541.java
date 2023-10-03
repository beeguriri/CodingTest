package com.study.codingtest.baekjoon.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
잃어버린 괄호
식의 값을 최소로 만들려면
마이너스가 나왔을때 다음 마이너스 전까지 다 더해줌
 */
public class B_1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String [] minusSplit = input.split("-");
        List<Integer> result = new ArrayList<>();
        for(String s : minusSplit){
            String [] temp = s.split("\\+");
            int sum = 0;
            for(String t : temp)
                sum += Integer.parseInt(t);
            result.add(sum);
        }

        //result에 있는거 계산해주기
        int answer = result.get(0);
        for(int i=1; i<result.size(); i++)
            answer -= result.get(i);

        System.out.println(answer);
    }
}
