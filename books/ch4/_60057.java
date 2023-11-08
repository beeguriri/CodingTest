package com.study.codingtest.books.ch4;

public class _60057 {

    public int solution(String s) {

        //압축할 문자열 단위는 전체 길이의 1/2만 확인 하면 됨
        int result = s.length();

        for(int i=1; i<=s.length()/2; i++) {

            String target = s.substring(0, i);
            int count = 1;
            String compare = "";
            StringBuilder sb = new StringBuilder();

            for(int j=i; j<=s.length(); j+=i) {
                //비교 할 문자열 설정
                if(j+i<=s.length())
                    compare = s.substring(j, j+i);
                else
                    compare = s.substring(j);

                //비교
                if(target.equals(compare))
                    count++;
                else {

                    //기존에 압축문자열 더해주고
                    if(count>1)
                        sb.append(count);
                    sb.append(target);

                    //타겟 재설정
                    target = compare;
                    count = 1;
                }

                //남은 문자열 처리
                if(target.length()<i)
                    sb.append(target);

            }

            // System.out.println(answer);
            result = Math.min(result, sb.toString().length());
        }
        return result;
    }
}
