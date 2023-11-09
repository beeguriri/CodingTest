package com.study.codingtest.books.ch12;

public class _43163 {

    static boolean [] check;

    static int answer = Integer.MAX_VALUE;

    static boolean isOneDiff(String w1, String w2) {

        int same = 0;

        for(int i=0; i<w1.length(); i++)
            if(w1.charAt(i)==w2.charAt(i))
                same++;

        return w1.length()-same == 1;
    }

    static void dfs(int count, String begin, String target, String [] words) {

        if(begin.equals(target)){
            answer = Math.min(answer, count);
            return;
        }

        for(int i=0; i<words.length; i++){
            if(!check[i] && isOneDiff(begin, words[i])) {
                check[i] = true;
                dfs(count+1, words[i], target, words);
                check[i] = false;
            }
        }

    }

    public int solution(String begin, String target, String[] words) {

        check = new boolean [words.length];
        dfs(0, begin, target,  words);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
