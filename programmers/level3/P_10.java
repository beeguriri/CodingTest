package com.study.codingtest.programmers.level3;

public class P_10 {

    public static int countInst(int begin, int end, int w){

        int count = (end-begin+1)/(2*w+1);

        if((end-begin+1)%(2*w+1)!=0)
            count++;

        return count;
    }

    public static int solution(int n, int[] stations, int w) {

        int answer = 0;
        int begin = 1;

        for(int i=0; i<stations.length; i++){
            //설치된 기지국 영향 받지 않는 인덱스까지
            //몇개 설치 되어야 하는지 계산 하는 메서드 만들어야 됨
            if(begin < stations[i]-w)
                answer+=countInst(begin, stations[i]-w-1, w);

            begin = stations[i]+w +1;
        }

        //마지막 기지국에서부터 뒤에 남은거 처리해주기
        if(begin<=n)
            answer += countInst(begin, n, w);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(11, new int [] {4, 11}, 1)); // 3
    }
}
