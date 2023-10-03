package com.study.codingtest.programmers.level2;

/*
광물 캐기
 */
public class P_76 {

    //picks는 [dia, iron, stone]
    static int min = Integer.MAX_VALUE;

    static int calcTable(String pick, String mine){
        if(pick.equals("dia")){
            if(mine.equals("diamond"))
                return 1;
            else if(mine.equals("iron"))
                return 1;
            else
                return 1;
        } else if (pick.equals("iron")){
            if(mine.equals("diamond"))
                return 5;
            else if(mine.equals("iron"))
                return 1;
            else
                return 1;
        } else {
            if(mine.equals("diamond"))
                return 25;
            else if(mine.equals("iron"))
                return 5;
            else
                return 1;
        }
    }

    static void dfs(int total, String tool, int index, String [] minerals, int dia, int iron, int stone){

        //종료조건
        if(index == minerals.length){
            min = Math.min(min, total);
            return;
        }

        total += calcTable(tool, minerals[index]);

        //곡괭이를 하나 선택해서 광물 5개를 연속으로 캐고,
        //다음 곡괭이를 선택해서 광물 5개를 연속으로 캐는 과정을 반복
        //더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
        //index 0, 5, 10, ... 순으로 새로운 곡괭이 선택해야 함
        //다음 index가 %5==0일때까지 반복
        if((index+1)%5!=0)
            dfs(total, tool, index+1, minerals, dia, iron, stone);
        else{

            if(dia==0 && iron==0 && stone==0){
                min = Math.min(min, total);
                return;
            }

            if(dia>0)
                dfs(total, "dia", index+1, minerals, dia-1, iron, stone);

            if(iron>0)
                dfs(total, "iron", index+1, minerals, dia, iron-1, stone);

            if(stone>0)
                dfs(total, "stone", index+1, minerals, dia, iron, stone-1);
        }
    }

    public int solution(int[] picks, String[] minerals) {

        if(picks[0]>0)
            dfs(0, "dia", 0, minerals, picks[0]-1, picks[1], picks[2]);

        if(picks[1]>0)
            dfs(0, "iron", 0, minerals, picks[0], picks[1]-1, picks[2]);

        if(picks[2]>0)
            dfs(0, "stone", 0, minerals, picks[0], picks[1], picks[2]-1);

        return min;
    }
}
