package com.week2;

import java.util.*;
import java.io.*;

public class BOJ_2294 {

    static int N, K;
    static List<Integer> coins = new ArrayList<>();
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            coins.add(coin);
        }

        for (int i = 1; i <= K; ++i) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != 100001) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        bw.write(String.valueOf(dp[K] == 100001 ? -1 : dp[K]));
        bw.flush();

        bw.close();
        br.close();
    }
}