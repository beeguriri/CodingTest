package com.study.codingtest.programmers.level2;

/*
스킬 트리
*/

public class P_37 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees) {

            String reg = "[^"+skill+"]";
            String temp = s.replaceAll(reg, "");
            // System.out.println(temp);

            if(temp.isEmpty()) {
                answer++;
                continue;
            }

            for(int i=1; i<=skill.length(); i++)
                if(skill.substring(0, i).equals(temp))
                    answer++;
        }

        return answer;
    }
}
