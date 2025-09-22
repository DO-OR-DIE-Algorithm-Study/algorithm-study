package com.week5;

import java.util.*;
import java.io.*;

public class BOJ_2412 {

    static List<Integer>[] holes;
    static int n, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        holes = new ArrayList[T + 1];
        for (int i = 0; i <= T; ++i) holes[i] = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (0 <= y && y <= T) holes[y].add(x);
        }

        System.out.print(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        int move = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                if (cy == T) return move;

                for (int ny = cy - 2; ny <= cy + 2; ++ny) {
                    if (ny < 0 || ny > T) continue;
                    List<Integer> list = holes[ny];
                    if (list.isEmpty()) continue;

                    // 사용한 홈은 바로 제거
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        int nx = it.next();
                        if (Math.abs(nx - cx) <= 2) {
                            q.offer(new int[]{nx, ny});
                            it.remove();
                        }
                    }
                }
            }
            move++;
        }
        return -1;
    }
}