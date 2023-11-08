package com.study.codingtest.books.ch7;

public class _42747 {

    public int solution(int[] citations) {
        int answer = 0;

        //제일 많이 인용 된 횟수를 찾은다음에 거기서부터 0까지 줄여가면서 h-index 찾고자 함!!
        int max = 0;
        for(int i : citations)
            max = Math.max(max, i);

        for(int h=max; h>=0; h--) {
            int count = 0;
            for(int i : citations) {
                //h번 이상 인용
                if(i>=h)
                    count++;
            }

            //h번 이상 인용 된 논문이 h편 이상,
            //나머지 논문이 h번 이하 인용 되었을 때
            //h-index
            if(count>=h && (citations.length-count)<=h)
                answer = Math.max(answer, h);
        }
        return answer;
    }
}
