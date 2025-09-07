package com.week3;

import java.util.*;
import java.io.*;

public class BOJ_13549 {

    static int N, K;
    static int[] minTime;
    static int MAX;

    public static void main(String[] args) throws IOException {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        MAX = N - K < 0 ? K * 2 : N * 2;

        minTime = new int[MAX + 1];
        Arrays.fill(minTime, -1);

        bfs();

        System.out.print(minTime[K]);
    }

    public static void bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        minTime[N] = 0;
        deque.add(N);

        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int[] npos = {cur*2, cur-1, cur+1};

            for (int i = 0; i < 3; ++i) {
                int next = npos[i];

                if (next < 0 || next > MAX) continue;
                if (minTime[next] != -1) continue;

                if (i == 0) {  // 순간이동
                    minTime[next] = minTime[cur];
                    deque.addFirst(next);
                } else {  // 1초 소요
                    minTime[next] = minTime[cur] + 1;
                    deque.addLast(next);
                }
            }
        }
    }
}
