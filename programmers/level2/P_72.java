package com.study.codingtest.programmers.level2;

/*
문자열 압축
 */
public class P_72 {

    public static int solution(String s) {
        int answer = s.length();

        //길이 1개 이상 ~ s의 절반길이까지 확인
        for(int i=1; i<=s.length()/2; i++) {

            StringBuilder sb = new StringBuilder();

            //제일 처음문자열부터 확인
            String target = s.substring(0, i);
            int count = 1;
            String compare;

            for(int j=i; j<=s.length(); j+=i) {

                //비교문자열 찾기
                if(j+i>s.length())
                    compare = s.substring(j);
                else
                    compare = s.substring(j, j+i);

                //문자열을 target과 비교하기
                if(compare.equals(target))
                    count++;
                else {
                    if(count >= 2)
                        sb.append(count).append(target);
                    else
                        sb.append(target);

                    //target 재설정
                    target = compare;
                    count = 1;

                }

                //남은 문자열 처리
                if(target.length()<i) {
                    sb.append(target);
                    break;
                }
            }
            // System.out.println(sb.toString());

            answer = Math.min(answer, sb.toString().length());

        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
