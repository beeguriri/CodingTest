package com.study.codingtest.programmers.level2;

/*
전화번호 목록
 */

import java.util.Arrays;

public class P_24 {

    static boolean solution(String[] phone_book) {

        //정렬 해서 바로 뒤에 번호랑만 비교해보면 됨!
        Arrays.sort(phone_book);

        for(int i=0; i< phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String [] {"119", "97674223", "1195524421"}));
    }
}
