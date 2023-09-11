package com.study.codingtest.programmers.level2;

public class P_05 {

    /*
    카펫
     */
    public int[] solution(int brown, int yellow) {
        
        int [] answer = new int [2];

        //yellow 정수*정수 쌍을 찾아서
        //각 변에 +2를 해준다음에
        //그것을 곱한 값에서 yellow 갯수 뺀 것이 brown이면 정답?!
        for(int i=1; i<=Math.sqrt(yellow); i++) {
            if(yellow%i==0) {
                int x = i+2;
                int y = yellow/i + 2;

                if(x*y-yellow==brown){
                    answer[0] = Math.max(x, y);
                    answer[1] = Math.min(x, y);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
