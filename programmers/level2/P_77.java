package com.study.codingtest.programmers.level2;

import java.util.*;

/*
우박수열 정적분
 */

public class P_77 {

    public double[] solution(int k, int[][] ranges) {

        //0 이상의 수 b에 대해 [a, -b]에 대한 정적분 결과는
        //x = a, x = n - b, y = 0 으로 둘러 쌓인 공간의 면적으로 정의하며,
        //이때 n은 k가 초항인 우박수열이 1이 될때 까지의 횟수를 의미합니다.

        double[] answer = new double[ranges.length];

        //수박수열 계산하기
        List<int []> list = new ArrayList<>();
        list.add(new int [] {0, k});
        int idx = 1;
        while(true){
            if(k%2==0)
                k/=2;
            else
                k = (k*3)+1;

            list.add(new int [] {idx++, k});

            if(k==1)
                break;
        }

        //전체구간에 대한 계산 일단 해놓고
        //사다리꼴의 넓이 = (y1+y2)*x/2;
        int n = idx-1;
        double[] total = new double[n];
        for(int i=0; i<list.size()-1; i++){
            int [] x1 = list.get(i);
            int [] x2 = list.get(i+1);

            total[i] = ((double)x1[1]+x2[1])/2;
        }

        //각 ranges에 대한 결과값 구하기
        for(int i=0; i<ranges.length; i++){
            int x1 = ranges[i][0];
            int x2 = n + ranges[i][1];

            if(x1>=n || x1>x2)
                answer[i] = -1.0;

            if(x1==x2)
                answer[i] = 0;

            for(int j=x1; j<x2; j++)
                answer[i] += total[j];

        }
        // System.out.println(Arrays.toString(total));


        // for(int [] i : list)
        //     System.out.println(Arrays.toString(i));
        
        return answer;
    }
}
