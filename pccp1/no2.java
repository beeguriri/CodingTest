package com.study.codingtest.pccp1;

public class no2 {

    //모든 순열 만들어서 풀기 (중복은 허용 안함)
    static boolean [] check;
    static int answer = 0;

    static void permutation(int sum, int depth, int n, int [][] ability){

        //dfs 종료조건
        if(depth==n){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<ability.length; i++) {
            if(!check[i]) {
                check[i] = true;
                permutation(sum+ability[i][depth], depth+1, n, ability);
                check[i] = false;
            }
        }
    }

    public int solution(int[][] ability) {
        //순열로 구하기
        int students = ability.length;
        int sports = ability[0].length;

        check = new boolean [students];
        permutation(0, 0, sports, ability);

        return answer;
    }
}
