package com.study.codingtest.pccp1;

public class no3 {

    //0~1/4까지는 "RR"
    //1/4 ~ 2/4는 윗세대 2번째 확인
    //2/4 ~ 3/4는 윗세대 3번째 확인
    //3/4 ~ 1은 "rr"

    static String recursive(int n, int p) {

        int cnt = (int) Math.pow(4, n-1);

        if(p<=cnt/4) return "RR";
        if(p>cnt/4*3) return "rr";
        if(n==2) return "Rr";
        if(p>cnt/4 && p<=cnt/2) return recursive(n-1, p-cnt/4);
        return recursive(n-1, p-cnt/2); //if(p>cnt*2/4 && p<=cnt*3/4)

    }

    public String[] solution(int[][] queries) {
        String[] answer = new String [queries.length];

        for(int i=0; i<queries.length; i++){
            answer[i] = queries[i][0]==1 ? "Rr" : recursive(queries[i][0], queries[i][1]);
        }
        return answer;
    }
}
