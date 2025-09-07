package com.week4;

import java.io.*;
import java.util.*;

public class BOJ_1477 {
    static int N, M, L;
    static int[] rest;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N + 2];
        rest[0] = 0;
        rest[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(rest);

        int lo = 1;
        int hi = L;
        int minLongest = L;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;   // 임시 최대 간격

            long need = 0; // mid를 최대 간격으로 만들기 위해 세워야 하는 휴게소 수

            for (int i = 0; i <= N; i++) {
                int dist = rest[i + 1] - rest[i];  // 휴게소 사이 간격
                if (dist > mid) {
                    int n = (dist - 1) / mid;  // dist가 mid보다 작게 만들기 위해 필요한 휴게소 수
                    need += n;
                    if (need > M) break;
                }
            }

            if (need <= M) {  // 세울 수 있는 휴게소가 남음
                minLongest = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(minLongest);
    }
}