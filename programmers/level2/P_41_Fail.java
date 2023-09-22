package com.study.codingtest.programmers.level2;

/*
2개 이하로 다른 비트
시간초과
 */

public class P_41_Fail {

    static boolean isOneDiff(String s1, String s2) {

        int count = 0;

        if(s1.length()>s2.length()) {
            while(s1.length()>=s2.length()) {
                s2 = "0"+s2;

                if(s1.length()==s2.length())
                    break;
            }
        } else if (s1.length()<s2.length()) {
            while(s1.length() <= s2.length()) {
                s1 = "0"+s1;

                if(s1.length()==s2.length())
                    break;
            }
        }

        // System.out.println(s1);
        // System.out.println(s2);

        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }

        return count<=2;

    }

    public long[] solution(long[] numbers) {
        long[] answer = new long [numbers.length];

        //numbers를 일단 스트링으로 바꾸고
        //numbers의 다음 숫자를 스트링으로 바꿔가면서 비교하면...?
        for(int i=0; i<numbers.length; i++) {
            long next = numbers[i]+1;
            while(true) {

                if(isOneDiff(Long.toString(numbers[i], 2), Long.toString(next, 2))) {
                    answer[i] = next;
                    break;
                } else
                    next++;
            }
        }

        return answer;
    }
}
