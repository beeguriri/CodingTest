package com.study.codingtest.programmers.level2;

/*
점프와 순간이동
 */
public class P_07 {

    public int solution(int n) {
        int ans = 0;

        //2로 나눠져서 0이면 점프하면 되니까
        //이진수 변환해서 1의 개수 세보기!
        String s = Integer.toString(n, 2);

        for(char c : s.toCharArray())
            if(c=='1')
                ans++;

        return ans;
    }

    public static void main(String[] args) {

    }
}
