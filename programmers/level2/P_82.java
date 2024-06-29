package com.study.codingtest.programmers.level2;

//[PCCP 기출문제] 3번 / 아날로그
//이 시계에는 초침이 시침/분침과 겹칠 때마다 알람이 울리는 기능이 있습니다.
public class P_82 {

    //현재 시간의 각도 계산
    //초침은 60초에 360도 움직임 => 1초에 6도
    //분침은 60분에 360도 움직임 => 1분에 6도, 1초에 0.1도
    //시침은 12시간에 360도 => 1시간에 30도, 1분에 0.5도, 1초에 0.5/60도
    public static double[] toDegree(int sec) {

        double [] degree = new double[3];

        int h = sec/3600;
        int m = (sec%3600)/60;
        int s = (sec%3600)%60;

        degree[0] = (h%12)*30 + m*0.5 + s*0.5/60;
        degree[1] = m*6 + s*0.1;
        degree[2] = s*6;

        return degree;
    }

    //초의 각도가 분침 또는 시침보다 전에 있다가
    //1초 후에 분침 또는 시침보다 뒤에 있으면 겹친 것
    public static boolean[] isMinSec(int beforeS, int nextS) {

        double [] now = toDegree(beforeS);
        double [] next = toDegree(nextS);

        boolean [] result = new boolean[3];

        //현재 초침과 분침이 같은 각도이면 알람이 한번만 울림
        if(next[0] == next[1]) return new boolean[] {true, false, false};


        //분침과 초침이 겹치는 지 확인
        if(now[1]>now[2] && next[1]<=next[2]) result[1] = true;

        //초침이 59초(354도) -> 0초로 넘어갈 때 확인
        if(now[2]==354 && next[1]>354) result[1] = true;

        //시침과 초침이 겹치는 지 확인
        if(now[0]>now[2] && next[0] <=next[2]) result[2] = true;

        //초침이 59초(354도) -> 0초로 넘어갈 때 확인
        if(now[2]==354 && next[0]>354) result[2] = true;

        return result;
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

        int count = 0;

        //시작이 0시0분0초 또는 12시0분0초이면 일단 한번 겹치고 시작함
        if((h1==0 && m1==0 && s1==0) || (h1==12 && m1==0 && s1==0)) count++;

        int start = h1*60*60 + m1*60 + s1;
        int end = h2*60*60 + m2*60 + s2;

        for(int i = start; i < end; i++) {
            boolean [] result = isMinSec(i, i+1);
            if(result[0]) count++;
            if(result[1]) count++;
            if(result[2]) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(solution(0,5,30,0,7,0)); //2
        System.out.println(solution(12,0,0,12,0,30)); //1
        System.out.println(solution(0,6,1,0,6,6)); //0
        System.out.println(solution(11,59,30,12,0,0)); //1
        System.out.println(solution(11,58,59,11,59,0)); //1
        System.out.println(solution(1,5,5,1,5,6)); //2
        System.out.println(solution(0,0,0,23,59,59)); //2852

    }
}
