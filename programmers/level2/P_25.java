package com.study.codingtest.programmers.level2;

/*
k진수에서 소수 개수 구하기
 */
public class P_25 {
    //소수 판별 메서드
    static boolean isPrime(long num) {

        for(int i=2; i<=Math.sqrt(num); i++)
            if(num%i==0)
                return false;

        return true;

    }

    public int solution(int n, int k) {

        int answer = 0;

        //입력된 숫자를 k진법으로 바꾸기
        String str = Integer.toString(n, k);

        //k진법으로 바뀐 숫자를 0 기준으로 분해
        str = str.replaceAll("[0]+", "0");
        String [] arr = str.split("0");

        // System.out.println(Arrays.toString(arr));

        //각 숫자는 10진법으로 변환해서 소수 여부 판별
        for(String s : arr) {
            if(s.equals("1"))
                continue;

            //데이터타입 확인!!!
            long number = Long.parseLong(s);
            if(isPrime(number))
                answer++;
        }

        return answer;
    }
}
