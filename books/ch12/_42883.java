package com.study.codingtest.books.ch12;

public class _42883 {

    public String solution(String number, int k) {

        //제거할 수가 k개 이므로, 출력해야 할 개수는 ans_len = number.length() - k
        //앞에서부터 ans_len까지 확인해서 최대값만 뽑음
        //최대값의 다음 인덱스부터 ans_len 만큼 확인 반복하기
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int i=0; i<number.length()-k; i++){

            int max = 0;

            //ans_len 만큼 반복하기 위해서 i+k
            for(int j=idx; j<=i+k; j++){
                int temp = Integer.parseInt(number.substring(j,j+1));
                if(temp>max){
                    max = temp;
                    idx = j;
                }
                if(max==9)
                    break;
            }

            //최대값 다음 위치에서부터 찾기위함
            idx += 1;
            sb.append(max);
        }

        return sb.toString();
    }
}
