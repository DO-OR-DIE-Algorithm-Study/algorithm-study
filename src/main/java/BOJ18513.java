import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18513 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] s = new int[n];
        boolean[] visit = new boolean[200000001];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            s[i] = Integer.parseInt(st.nextToken());
            visit[s[i] + 100000000] = true;
        }

        /**
         * 내 아이디어
         * 우선순위 큐를 사용해서 샘터 위치에서 +-1, +-2... 이런식으로 BFS 돌려서 집의 위치를 결정해주고
         * 중복된 위치에 대해서는 배열로 관리한다.
         */


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        long answer = 0;

        for (int i : s) {
            pq.add(new int[]{1, i, -1});
            pq.add(new int[]{1, i, 1});
        }

        while (k > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            int distance = cur[0];
            int coordinate = cur[1];
            int direction = cur[2];

            int _coordinate = coordinate + direction;

            if(_coordinate <= 100000000 && _coordinate >= -100000000 && !visit[_coordinate + 100000000]){
                visit[_coordinate + 100000000] = true;
                k--;
                answer += distance;
                pq.add(new int[]{distance + 1, _coordinate, direction});
            }
        }

        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
