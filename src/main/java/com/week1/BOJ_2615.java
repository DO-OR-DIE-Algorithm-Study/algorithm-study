package com.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615 {// 첫 번째 돌이 가장 왼쪽에 위치하도록
    // [오른쪽 위, 오른쪽, 오른쪽 아래, 아래]만 탐색
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};

    static int ROW = 19, COL = 19;
    static int BLACK = 1, WHITE = 2;
    static int[][] board = new int[ROW+1][COL+1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= ROW; ++i) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= COL; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= ROW; ++i) {
            for (int j = 1; j <= COL; ++j) {

                if (board[i][j] == 0) continue;

                if (isWinner(i, j)) {

                    System.out.println(board[i][j]);
                    System.out.println(i + " " + j);

                    return;
                }

            }
        }

        System.out.println("0");

        br.close();
    }

    private static boolean isWinner(int x, int y) {

        int stone = board[x][y];

        // 왼쪽에서부터 탐색 -> 오른쪽, 아래, 오른쪽 대각선 방향으로만 체크하면 된다.
        for (int k = 0; k < 4; ++k) {

            // 역방향에 같은 색의 돌이 있으면, 5목이 만들어질 수 없기 때문에 넘어가기
            if (isValid(x - dx[k], y - dy[k]) && board[x - dx[k]][y - dy[k]] == stone) {
                continue;
            }

            int count = 1;
            int nx = x + dx[k];
            int ny = y + dy[k];

            while (isValid(nx, ny) && board[nx][ny] == stone) {

                count++;

                nx += dx[k];
                ny += dy[k];
            }

            if (count == 5) return true;
        }

        return false;
    }

    private static boolean isValid(int x, int y) {
        return x >= 1 && x <= ROW && y >= 1 && y <= COL;
    }

}