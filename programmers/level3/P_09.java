package com.study.codingtest.programmers.level3;

import java.util.*;

public class P_09 {
    /*
        숫자 게임
        B 팀원들이 얻을 수 있는 최대 승점을 return 하도록
     */

    public static int solution(int[] A, int[] B) {

        int answer = 0;
        Deque<Integer> dq = new LinkedList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i : B)
            dq.offer(i);

        //A의 최대값과 B의 최대값을 비교해서
        //A의 최대값보다 최소로 큰값
        //같거나 작으면, 최대로 작은값을 카드로 내면 됨
        for(int i=A.length-1; i>=0; i--) {
            if(A[i]<dq.peekLast()) {
                dq.pollLast();
                answer++;
            }
            else
                dq.pollFirst();

        }

        return answer;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(new int [] {5,1,3,7}, new int [] {2,2,6,8}));
    }
}
