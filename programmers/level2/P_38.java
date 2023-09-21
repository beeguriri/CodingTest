package com.study.codingtest.programmers.level2;

import java.util.*;
/*
파일명 정렬
1. 파일명은 우선 HEAD 부분을 기준으로 사전 순으로 정렬 (대소문자 구분X)
2. NUMBER의 숫자 순으로 정렬한다. 숫자 앞의 0은 무시되며, 012와 12는 정렬 시에 같은 같은 값으로 처리된다.
3. 두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지
*/

public class P_38 {

    static boolean isNumber(char c) {
        return c>='0' && c<='9';
    }

    static String [] nameSplit(String s) {

        int cur = 0;
        String [] answer = new String [3];

        s = s.toUpperCase();

        //HEAD 찾기
        for(char c : s.toCharArray()) {
            if(!isNumber(c))
                cur++;
            else
                break;
        }

        answer[0] = s.substring(0, cur);
        s = s.substring(cur);
        cur = 0;

        //NUMBER 찾기
        for(char c : s.toCharArray()) {
            if(isNumber(c))
                cur++;
            else
                break;
        }

        if(cur>=s.length())
            answer[1] = s;
        else {
            answer[1] = s.substring(0, cur);
            answer[2] = s.substring(cur);
        }

        return answer;
    }

    public String[] solution(String[] files) {

        String[] answer = new String[files.length];

        Arrays.sort(files, (o1, o2) -> {

            String [] split1 = nameSplit(o1);
            String [] split2 = nameSplit(o2);

            return split1[0].compareTo(split2[0]) == 0 ?
                    Integer.parseInt(split1[1]) - Integer.parseInt(split2[1]) :
                    split1[0].compareTo(split2[0]);

        });

        return files;
    }
}
