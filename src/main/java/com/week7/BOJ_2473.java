package com.week7;

import java.util.*;
import java.io.*;

public class BOJ_2473 {

    static int N;
    static long[] arr;       // 합이 3e9까지 갈 수 있으니 long로 받자
    static long best = Long.MAX_VALUE;
    static long a, b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N - 2; ++i) {
            int l = i + 1, r = N - 1;
            while (l < r) {
                long sum = arr[i] + arr[l] + arr[r];

                if (Math.abs(sum) < Math.abs(best)) {
                    best = sum;
                    a = arr[i]; b = arr[l]; c = arr[r];
                    if (best == 0) {
                        System.out.println(a + " " + b + " " + c);
                        return;
                    }
                }

                if (sum < 0) l++;
                else r--;
            }
        }

        System.out.println(a + " " + b + " " + c);
    }
}