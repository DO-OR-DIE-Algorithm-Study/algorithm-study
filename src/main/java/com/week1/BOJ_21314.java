package com.week1;

import java.util.*;

public class BOJ21314 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        /**
         * 최댓값
         * - M이 연속으로 나오는 경우엔 K가 나올 때까지 쌓아뒀다가 '500..' 형태로 만드는 것이 항상 최적
         * - 마지막에 M으로 끝나면, M은 모두 '1'로 변환하는 것이 최적
         */
        StringBuilder max =  new StringBuilder();
        int countinuousMCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'M') {
                countinuousMCount++;
            }
            else {
                max.append('5');
                for (int i = 0; i < countinuousMCount; i++) {
                    max.append('0');
                }
                countinuousMCount = 0;
            }
        }

        // 십진수로 변환하지 못한 M으로 구성된 문자열이 남은 경우
        if (countinuousMCount != 0) {
            for (int i = 0; i < countinuousMCount; i++) {
                max.append('1');
            }
        }

        System.out.println(max);

        /**
         * 최솟값
         * - 연속된 M은 첫 번째만 '1'로 나머지는 0으로 하는 것이 항상 최적
         * - K는 무조건 '5'로 변환하는 것이 항상 최적
         */
        StringBuilder min =  new StringBuilder();
        boolean isContinuousM = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'M') {
                if (isContinuousM) {
                    min.append('0');
                    continue;
                }
                min.append('1');
                isContinuousM = true;
            }
            else {
                min.append('5');
                isContinuousM = false;
            }
        }

        System.out.println(min);
    }

}