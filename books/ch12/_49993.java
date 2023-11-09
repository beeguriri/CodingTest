package com.study.codingtest.books.ch12;

public class _49993 {

    public int solution(String skill, String[] skill_trees) {

        //탐색범위 줄이기 위하여
        //skill에 포함 된 글자 제외하고 모두 없애줌
        String reg = "[^"+skill+"]";
        int answer = 0;

        for(String skill_tree : skill_trees){

            skill_tree = skill_tree.replaceAll(reg, "");

            if(skill_tree.isEmpty()){
                answer++;
                continue;
            }

            //남은 문자열로 확인
            for(int i=1; i<=skill.length(); i++)
                if(skill.substring(0, i).equals(skill_tree))
                    answer++;
        }

        return answer;
    }
}
