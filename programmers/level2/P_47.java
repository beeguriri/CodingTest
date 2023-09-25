package com.study.codingtest.programmers.level2;

/*
삼각 달팽이
 */

public class P_47 {
    public int[] solution(int n) {
        int[] answer = new int [n*(n+1)/2];
        int [][] result = new int [n][n];

        int num = 1;
        int x = -1;
        int y = 0;


        for(int i=0; i<n; i++){ //0번째 => 4개, 1번째 => 3개, ...
            for(int j=i; j<n; j++) {
                if(i%3==0)
                    x++;
                else if(i%3==1)
                    y++;
                else {
                    x--;
                    y--;
                }
                result[x][y] = num++;
            }
        }

        // for(int [] i : result)
        //     System.out.println(Arrays.toString(i));

        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[idx++] = result[i][j];
            }
        }

        return answer;
    }
}
