package com.study.codingtest.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B_2002 {

    /*
    추월
    n개줄 : 차량 들어간 순
    다음 n개줄 : 차량 나오는 순
    들어간 순서 대로 맵에 넣고
    나갈때의 순번이 뒤에 애들보다 크면 추월!
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int [] outArray = new int [n];

        //들어갈 때
        for(int i=0; i<n; i++)
            map.put(br.readLine(), i);

        //나올때 순서
        for(int i=0; i<n; i++)
            outArray[i] = map.get(br.readLine());

        //나오는 배열 확인
        int count = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++) {
                if(outArray[i]>outArray[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);

    }
}
