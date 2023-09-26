package com.study.codingtest.programmers.level2;

/*
큰 수 만들기
 */

public class P_48 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<number.length()-k; i++) {
            //해당 범위의 최대값 가져오기
            //빼야될게 k개면,  가져가야될건 length-k개
            //최대값 인덱스 뒤에서부터 다시 탐색
            int max = 0;
            for(int j=idx; j<=i+k; j++) {
                if(Integer.parseInt(number.substring(j, j+1))>max) {
                    max = Integer.parseInt(number.substring(j, j+1));
                    idx = j;
                    //시간초과 해결 위함
                    if(max==9)
                        break;
                }
            }
            idx += 1;
            sb.append(max);

        }

        return sb.toString();
    }
}
