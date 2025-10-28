package com.week6;

import java.util.*;
import java.io.*;

public class BOJ_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(houses);

        // 파라메트릭 서치 구간: [lo, hi]
        int lo = 1; // 최소 간격 하한
        int hi = houses[N - 1] - houses[0];  // 최소 간격 상한
        int answer = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2; // 시험할 최소 간격
            if (canInstall(houses, C, mid)) {  // mid 간격으로 C개 설치 "가능"
                answer = mid; // 가능한 값이므로 기록
                lo = mid + 1; // 더 큰 간격 도전 (최댓값 찾기)
            } else { // "불가능"
                hi = mid - 1; // 간격 줄이기
            }
        }

        System.out.println(answer); // 가능한 최소 간격의 최댓값
    }

    static boolean canInstall(int[] houses, int need, int distance) {
        // 맨 앞 집에 설치하고, 이후 distance 이상 떨어진 가장 이른 집마다 설치(그리디 방식)
        int count = 1;
        int last = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - last >= distance) {
                count++;
                last = houses[i];
                if (count >= need) return true; // 충분히 설치 가능
            }
        }
        return false; // 설치할 공유기 부족
    }

}