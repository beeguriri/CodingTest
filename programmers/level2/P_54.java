package com.study.codingtest.programmers.level2;

/*
방금 그곡
 */

public class P_54 {

    //문자열 대체
    static String changeNote(String s) {

        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("F#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");

        return s;
    }

    //재생시간 계산
    static int calcTime(String t1, String t2) {

        int h1 = Integer.parseInt(t1.split(":")[0]);
        int m1 = Integer.parseInt(t1.split(":")[1]);
        int h2 = Integer.parseInt(t2.split(":")[0]);
        int m2 = Integer.parseInt(t2.split(":")[1]);

        return (h2-h1)*60 + (m2-m1);

    }

    public String solution(String m, String[] musicinfos) {

        String answer = "";
        int maxPlayTime = -1;

        m = changeNote(m);

        for(String info : musicinfos){

            //정보 분리
            String [] temp = info.split(",");
            int time = calcTime(temp[0], temp[1]);
            String title = temp[2];
            String note = changeNote(temp[3]);

            //노트 정리
            while(note.length() <= time)
                note += note;

            note = note.substring(0, time);
            // System.out.println(note);

            //재생 시간 제일 긴 음악 제목 반환
            //재생 시간이 같을 경우 먼저 입력 된 음악 제목 반환
            if(note.contains(m) && maxPlayTime < time){
                maxPlayTime = time;
                answer = title;
            }

        }

        return maxPlayTime == -1 ? "(None)" : answer;
    }
}
