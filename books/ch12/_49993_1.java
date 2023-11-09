package com.study.codingtest.books.ch12;

public class _49993_1 {

    static boolean checkString(String skill, String skill_tree){

        int prev = 0;

        for(int i = 0; i < skill.length(); i++){
            for(int j = 0; j < skill_tree.length(); j++){

                //같은 글자를 찾았을 때
                if(skill.charAt(i) == skill_tree.charAt(j)){
                    //앞에 이미 나온 글자면 실패
                    if(prev > j)
                        return false;
                    //아니면 현재 시점 에서 찾기 중단 후 skill의 다음 글자 탐색
                    break;
                }

                //같은 글자가 아니면, prev 증가 시켜줌
                //==> prev가 가지고 있는 값은 이전에 찾은 글자와 같은 인덱스
                //이때 까지 찾은 문자열의 다음 문자열 찾을 때만 prev 갱신 시킬 거
                if(prev <= j)
                    prev = j+1;

            }
        }
        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String tree : skill_trees)
            if(checkString(skill, tree))
                answer++;

        return answer;
    }
}
