package com.week1;

import java.util.*;
import java.io.*;

public class BOJ_14888 {

    static int[] num;
    static int[] operators = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; ++i) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();

        br.close();
    }

    private static void dfs(int value, int depth) {

        // 모든 연산자를 끼워넣은 결과값과 기존 최댓값/최솟값 비교
        if (depth == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; ++i) {
            if (operators[i] > 0) {

                operators[i]--; // 연산자 1개 사용

                switch (i) {
                    case 0: dfs(value + num[depth], depth + 1); break;
                    case 1: dfs(value - num[depth], depth + 1); break;
                    case 2: dfs(value * num[depth], depth + 1); break;
                    case 3: dfs(value / num[depth], depth + 1); break;
                }

                operators[i]++; // 백트래킹에 사용한 연산자 복구
            }
        }
    }

}